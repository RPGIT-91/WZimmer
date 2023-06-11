package test;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
	private MyView view;
	private List<Patient> patients;

	public Controller(MyView view) {
		this.view = view;
		this.patients = new ArrayList<>();

		// Example patients for testing
		Patient patient1 = new Patient("John Doe", 30, "john.doe@example.com", "Hemorrhoids", "10:00 AM");
		Patient patient2 = new Patient("Jane Smith", 45, "jane.smith@example.com", "", "11:00 AM");

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

	}


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
}