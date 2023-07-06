//Hier werden die Funktionalitäten hinter den Knöpfen angelegt.

package gui;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import user.Patient;

public class Controller {
	private MyView view;
	private Anzeige wz;
	private List<Patient> patients;

	//beispielhafte Daten. In einer richtigen Anwendung wäre hier eine DB Anbindung.
	public Controller(MyView view) {
		this.view = view;
		this.patients = new ArrayList<>();

		// Example patients for testing
		Patient patient1 = new Patient("John Doe", 30, "john.doe@example.com", "Musterstrasse 1", 12, "0152565581", "A000000001", "TK", "Hemorrhoids", "10:00 AM", patients.size());
		Patient patient2 = new Patient("Jane Smith", 45, "jane.smith@example.com", "Musterstrasse 2", 12, "0152565582", "A000000002", "TK", "", "11:00 AM", patients.size());

		patients.add(patient1);
		patients.add(patient2);

		// Add patients to the view
		for (Patient patient : patients) {
			view.addPatient(patient);
		}
		// Register action listeners for the buttons
		view.addAddPatientListener(new AddPatientListener());
		view.addEditPatientListener(new EditPatientListener());
		view.addViewDetailsListener(new ViewDetailsListener());
		view.addBehandlungListener(new BehandlungListener());
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
				JOptionPane.showMessageDialog(view, "Please select a patient.", "warning", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	private class BehandlungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Patient patient = model.nextPatient(); //Methode um nächsten Patienten aus dem Wartezimmer zu holen.
            if (patient != null) {
                Random random = new Random();
                if (random.nextInt(100) < 5) {
                    System.out.println(patient.getName() + " ist verstorben. Beweismittel werden vernichtet.");
                } else {
                    System.out.println(patient.getName() + " wurde behandelt und verlässt das Wartezimmer.");
                }
                updatePatientList();
            } else {
                System.out.println("Keine Patienten im Wartezimmer.");
            }
        }
    };
	
/////////////////////////////////////////////////////////////////////////////////
	//
	public Controller(Anzeige wz) {
		this.wz = wz;
	}
	
}