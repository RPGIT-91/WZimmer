//Hier werden die Funktionalitäten hinter den Knöpfen angelegt.

package gui;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import user.Patient;

public class Controller {
	private MyView view;
	private List<Patient> patients;
	private WaitingRoom waitingRoom;
	private Anzeige waitingAnzeige;
	private boolean isWaitingRoomRunning = false;
	
	
	//Test für Alex!! Einbinden von PatientAdden
	PatientAdden patientadden = new PatientAdden();
	

	//beispielhafte Daten. In einer richtigen Anwendung wäre hier eine DB Anbindung.
	public Controller(MyView view) {
		this.view = view;
		this.waitingRoom = new WaitingRoom();
		
		//////// Datenbank initialisieren
		this.patients = new ArrayList<>();
		// Example patients for testing
		Patient patient1 = new Patient("John Doe", 30, "john.doe@example.com", "Musterstrasse 1", 12, "0152565581", "A000000001", "TK", "Hemorrhoids", "10:00 AM", patients.size()+1);
		patients.add(patient1);
		Patient patient2 = new Patient("Jane Smith", 45, "jane.smith@example.com", "Musterstrasse 2", 12, "0152565582", "A000000002", "TK", "", "11:00 AM", patients.size()+1);
		patients.add(patient2);
		
		//Test für Alex!!
		Patient patient3 = new Patient("Jane Smith", 45, "jane.smith@example.com", "Musterstrasse 2", 12, "0152565582", "A000000002", "TK", "", "11:00 AM", patients.size()+1);
		patients.add(patient3);
		
		
		
		
		// Add patients to the view
		for (Patient patient : patients) {
			view.addPatient(patient);
			
			
		////////	
		}
		// Register action listeners for the buttons
		view.addAddPatientListener(new AddPatientListener());
		view.addEditPatientListener(new EditPatientListener());
		view.addViewDetailsListener(new ViewDetailsListener());
		view.addBehandlungListener(new BehandlungListener());
		view.addToWaitListListener(new AddToWaitListListener());
	}

// Button actions
	// ActionListener for the "Add Patient" button    
	private class AddPatientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Implement the logic for adding a patient here
		}
	}

	// ActionListener for the "Edit Patient" button
	private class EditPatientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// Implement the logic for editing a patient here
		}
	}

	// ActionListener for the "View Details" button
	private class ViewDetailsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = view.getSelectedRowIndex();
			if (selectedRow != -1) {
				Patient selectedPatient = patients.get(selectedRow);
				view.showPatientInfo(selectedPatient);
			} else {
				JOptionPane.showMessageDialog(view, "Please select a patient.", "Warning", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	private class BehandlungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	//removes entry from Anzeige as well as waitingRoom.
        	Patient behandelt = waitingRoom.doTreatment();
        	if (behandelt != null) {
        		waitingAnzeige.removePatient(behandelt);
        		
        		// check if treatment is successful
                // Generate a random number between 0 and 99
                Random random = new Random();
                int chance = random.nextInt(100);
                
                if (chance < 90) {
                    // Handle the treatment going wrong
                	JOptionPane.showMessageDialog(null, "Patient ist Tot.\nBeweise werden vernichtet.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                	
                	//Delete patient info from view and from programn.
                	view.removePatient(behandelt.getPatientId()-1);                               
                	patients.remove(behandelt.getPatientId()-1);
                	//add deletion from txt.                	
                	
                	
                } else {
                    // Handle the successful treatment
                	JOptionPane.showMessageDialog(null, "Patient ist am leben.\nwir haben garantiert nichts mit dem Organhandel zu tun.", "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "No patients in the waitingroom.", "Warning", JOptionPane.INFORMATION_MESSAGE);
        	}
         
        }
    };
	
    //Button to add patient to the WaitingRoom.
    private class AddToWaitListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getSelectedRowIndex();
            if (selectedRow != -1) {
                Patient selectedPatient = getSelectedPatient(selectedRow);

                // Add the selected patient to the waiting room
                waitingRoom.addPatient(selectedPatient);

                // Check if waitingAnzeige is already running
                if (!isWaitingRoomRunning) {
                    waitingAnzeige = new Anzeige();
                    isWaitingRoomRunning = true;
                }

                // Update the waitingAnzeige with the patients from waitingRoom
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
        if (selectedRow >= 0 && selectedRow < patients.size()) {
            return patients.get(selectedRow);
        } else {
            return null;
        }
    }

/////////////////////////////////////////////////////////////////////////////////
}