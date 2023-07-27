//Hier werden die Funktionalitäten hinter den Knöpfen angelegt.

package gui;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import user.Patient;

// Declare the Controller class
public class Controller {
	private MyView view; // The main view instance used to interact with GUI
	private List<Patient> patients; // The list of patients
	private WaitingRoom waitingRoom; // The waiting room instance
	private Anzeige waitingAnzeige; // The display instance to show waiting room
	private boolean isWaitingRoomRunning = false; // Boolean to check if waiting room is running or not

	// Constructor for the Controller class
	public Controller(MyView view) {
		// Initialize the main view and waiting room
		this.view = view;
		this.waitingRoom = new WaitingRoom();
		
		// Initialize the patients list
		this.patients = new ArrayList<>();
		// Create two example patients for testing
		Patient patient1 = new Patient("John Doe", 30, "john.doe@example.com", "Musterstrasse 1", "12", "0152565581", "A000000001", "TK", "Hemorrhoids", "10:00", patients.size()+1);
		patients.add(patient1);
		Patient patient2 = new Patient("Jane Smith", 45, "jane.smith@example.com", "Musterstrasse 2", "12", "0152565582", "A000000002", "TK", "", "11:00", patients.size()+1);
		patients.add(patient2);
		
		// Add the created patients to the GUI
		for (Patient patient : patients) {
			view.addPatient(patient);
		}
		
		// Register action listeners for the buttons on the GUI
		view.addAddPatientListener(new AddPatientListener());
		view.addEditPatientListener(new EditPatientListener());
		view.addViewDetailsListener(new ViewDetailsListener());
		view.addBehandlungListener(new BehandlungListener());
		view.addToWaitListListener(new AddToWaitListListener());
	}

	// ActionListener for the "Add Patient" button
	private class AddPatientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// When the "Add Patient" button is clicked, create a new patient and add it to the patient list and the view
			view.addPatientNew(patients.size() + 1, newPatient -> {
				if (!newPatient.getName().isEmpty()) {
					patients.add(newPatient);
					view.addPatient(newPatient);
				}
			});
		}
	}

	// ActionListener for the "Edit Patient" button
	private class EditPatientListener implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        int selectedRow = view.getSelectedRowIndex();
	        if (selectedRow != -1) {
	            Patient selectedPatient = patients.get(selectedRow);
	            view.editPatientInfo(selectedPatient, editedPatient -> {
	                // Update the selectedPatient with the changes from the editedPatient
	                selectedPatient.setName(editedPatient.getName());
	                selectedPatient.setAge(editedPatient.getAge());
	                selectedPatient.setContactDetails(editedPatient.getContactDetails());
	                selectedPatient.setAdress(editedPatient.getAdress());
	                selectedPatient.setPlz(editedPatient.getPlz());
	                selectedPatient.setTelephone(editedPatient.getTelephone());
	                selectedPatient.setMedicalHistory(editedPatient.getMedicalHistory());
	                selectedPatient.setInsuranceNo(editedPatient.getInsuranceNo());
	                selectedPatient.setInsuranceInstitute(editedPatient.getInsuranceInstitute());
	                selectedPatient.setAppointmentTime(editedPatient.getAppointmentTime());

	                // Now, the changes made to the selectedPatient are saved.
	                // You can also trigger any further actions or updates here.

	                // For example, you can update the view to reflect the changes:
	                view.updatePatient(selectedRow, editedPatient);
	                //list of patients in the controller, you can update it as well.
	                patients.set(selectedRow, editedPatient);
	            });
	        } else {
	            JOptionPane.showMessageDialog(view, "Please select a patient.", "Warning", JOptionPane.INFORMATION_MESSAGE);
	        }
	    }
	}







	// ActionListener for the "View Details" button
	private class ViewDetailsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// When the "View Details" button is clicked, display the selected patient's details or show a warning if no patient is selected
			int selectedRow = view.getSelectedRowIndex();
			if (selectedRow != -1) {
				Patient selectedPatient = patients.get(selectedRow);
				view.showPatientInfo(selectedPatient);
			} else {
				JOptionPane.showMessageDialog(view, "Please select a patient.", "Warning", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// ActionListener for the "Treatment" button
	private class BehandlungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	// Remove a patient from the waiting room and display. Simulate a random outcome of the treatment
        	Patient behandelt = waitingRoom.doTreatment();
        	if (behandelt != null) {
        		waitingAnzeige.removePatient(behandelt);
                
                Random random = new Random();
                int chance = random.nextInt(100);
                
                if (chance < 90) {
                	// If the random number is less than 90, simulate an unsuccessful treatment
                	JOptionPane.showMessageDialog(null, "Patient has died.\nDestroying evidence.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                	
                	// Delete the patient's details from the view and the patient list
                	view.removePatient(behandelt.getPatientId()-1);                               
                	patients.remove(behandelt.getPatientId()-1);
                	
                } else {
                	// If the random number is greater than or equal to 90, simulate a successful treatment
                	JOptionPane.showMessageDialog(null, "Patient is alive.\nWe have nothing to do with organ trafficking.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
        	} else {
        		// If no patient is in the waiting room, display a warning
        		JOptionPane.showMessageDialog(null, "No patients in the waiting room.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        	}
        	
        	// Update the number of currently waiting patients
        	if (waitingAnzeige != null) {
        		JPanel waitPanel = waitingAnzeige.getWaitPanel();
                JLabel waitingLabel = (JLabel) waitPanel.getComponent(0);
                waitingLabel.setText("Currently Waiting: " + waitingAnzeige.getRows());
        	}

        }
    };

    // ActionListener for the "Add to Wait List" button
    private class AddToWaitListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // When the "Add to Wait List" button is clicked, add the selected patient to the waiting room and display or show a warning if no patient is selected
            int selectedRow = view.getSelectedRowIndex();
            if (selectedRow != -1) {
                Patient selectedPatient = getSelectedPatient(selectedRow);

                // Add the selected patient to the waiting room
                waitingRoom.addPatient(selectedPatient);

                // Check if the waiting room display is already running, if not, start it
                if (!isWaitingRoomRunning) {
                    waitingAnzeige = new Anzeige();
                    isWaitingRoomRunning = true;
                }
                
                // Update the waiting room display with the patients in the waiting room
                waitingAnzeige.addPatient(selectedPatient);
                
                JPanel waitPanel = waitingAnzeige.getWaitPanel();
                JLabel waitingLabel = (JLabel) waitPanel.getComponent(0);
                waitingLabel.setText("Currently Waiting: " + waitingAnzeige.getRows());
                
            } else {
                JOptionPane.showMessageDialog(view, "Please select a patient.", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    
    // Helper method to get the selected patient
    private Patient getSelectedPatient(int selectedRow) {
        // Check if the provided row index is valid, and if it is, return the patient at that index
        if (selectedRow >= 0 && selectedRow < patients.size()) {
            return patients.get(selectedRow);
        } else {
            return null;
        }
    }
}
