/* Diese Klasse ist der Controller, der die Funktionalitäten hinter den GUI-Buttons implementiert.
 *  Jeder ActionListener reagiert auf bestimmte Benutzerinteraktionen und führt die entsprechenden Aktionen aus, 
 *  z. B. das Hinzufügen eines Patienten, das Bearbeiten von Patientendaten, das Anzeigen von Patientendetails, 
 *  das Ausführen einer Behandlung oder das Hinzufügen eines Patienten zum Wartezimmer.
 */
package gui;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import user.*;

public class Controller {
	private MyView view; // Die Haupt-View-Instanz zum Interagieren mit der GUI
	private List<Patient> patients; // Die Liste der Patienten
	private IWaitingRoomOperations waitingRoom; // Die Wartezimmer-Instanz
	private IAnzeigeOperations waitingAnzeige; // Die Anzeige-Instanz zur Darstellung des Wartezimmers
	private boolean isWaitingRoomRunning = false; // Boolean, um zu überprüfen, ob das Wartezimmer läuft oder nicht

	// Konstruktor für die Controller-Klasse
	public Controller(MyView view) {
		// Initialisiere die Haupt-View und das Wartezimmer
		this.view = view;
		waitingRoom = new WaitingRoom();

		// Initialisiere die Liste der Patienten
		patients = new ArrayList<>();
		// Erstelle Beispiel-Patienten zum Testen
		Patient patient1 = new Patient("John Doe", 30, "john.doe@example.com", "Musterstrasse 1", "12", "0152565581",
				"A000000001", "TK", "Hämorrhoiden", "10:00", patients.size() + 1);
		patients.add(patient1);
		Patient patient2 = new Patient("Jane Smith", 45, "jane.smith@example.com", "Musterstrasse 2", "12",
				"0152565582", "A000000002", "TK", "", "11:00", patients.size() + 1);
		patients.add(patient2);
		Patient patient3 = new Patient("Max Mustermann", 28, "max.mustermann@example.com", "Beispielweg 3", "34", "0152565583",
		        "A000000003", "TK", "Erkältung", "14:30", patients.size() + 1);
		patients.add(patient3);

		Patient patient4 = new Patient("Maria Schmidt", 55, "maria.schmidt@example.com", "Musterallee 7", "56", "0152565584",
		        "A000000004", "AOK", "Rückenschmerzen", "15:00", patients.size() + 1);
		patients.add(patient4);

		Patient patient5 = new Patient("Michael Müller", 42, "michael.mueller@example.com", "Musterplatz 12", "78", "0152565585",
		        "A000000005", "BARMER", "Kopfschmerzen", "16:00", patients.size() + 1);
		patients.add(patient5);

		// Füge die erstellten Patienten der GUI hinzu
		for (Patient patient : patients) {
			view.addPatient(patient);
		}

		// Registriere Action-Listener für die Buttons in der GUI
		view.addAddPatientListener(new AddPatientListener());
		view.addEditPatientListener(new EditPatientListener());
		view.addViewDetailsListener(new ViewDetailsListener());
		view.addBehandlungListener(new BehandlungListener());
		view.addToWaitListListener(new AddToWaitListListener());
	}

	// ActionListener für den "Patient hinzufügen"-Button
	private class AddPatientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Wenn der "Patient hinzufügen"-Button geklickt wird, erstelle einen neuen
			// Patienten
			// und füge ihn der Patientenliste und der View hinzu
			view.addPatientNew(patients.size() + 1, newPatient -> {
				if (!newPatient.getName().isEmpty()) {
					patients.add(newPatient);
					view.addPatient(newPatient);
				}
			});
		}
	}

	// ActionListener für den "Patient bearbeiten"-Button
	private class EditPatientListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = view.getSelectedRowIndex();
			if (selectedRow != -1) {
				Patient selectedPatient = patients.get(selectedRow);
				view.editPatientInfo(selectedPatient, editedPatient -> {
					// Aktualisiere den ausgewählten Patienten mit den Änderungen aus editedPatient
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

					// Die Änderungen am ausgewählten Patienten sind nun gespeichert.
					// Weitere Aktionen oder Updates können hier ebenfalls ausgelöst werden.

					// Zum Beispiel kann die View aktualisiert werden, um die Änderungen
					// widerzuspiegeln:
					view.updatePatient(selectedRow, editedPatient);
					// Aktualisiere auch die Liste der Patienten in der Controller-Klasse.
					patients.set(selectedRow, editedPatient);
				});
			} else {
				JOptionPane.showMessageDialog(view, "Bitte wählen Sie einen Patienten aus.", "Warnung",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// ActionListener für den "Details anzeigen"-Button
	private class ViewDetailsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Wenn der "Details anzeigen"-Button geklickt wird, zeige die Details des
			// ausgewählten
			// Patienten an oder zeige eine Warnung, wenn kein Patient ausgewählt ist
			int selectedRow = view.getSelectedRowIndex();
			if (selectedRow != -1) {
				Patient selectedPatient = patients.get(selectedRow);
				view.showPatientInfo(selectedPatient);
			} else {
				JOptionPane.showMessageDialog(view, "Bitte wählen Sie einen Patienten aus.", "Warnung",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// ActionListener für den "Behandlung"-Button
	private class BehandlungListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Speichere den Namen des Patienten, der die Behandlung erhält, für die Meldung
			if (waitingRoom.getPersons().peek() != null) {
				String patname = waitingRoom.getPersons().peek().getName();
				// Entferne einen Patienten aus dem Wartezimmer und simuliere ein zufälliges
				// Ergebnis
				Person behandelt = waitingRoom.doTreatment();
				if (behandelt != null) {
					waitingAnzeige.removePatient(behandelt);
					// Zufallsbasiertes Verhalten der Behandlung simulieren
					Random random = new Random();
					int chance = random.nextInt(100);
					if (chance < 20) {
						// Wenn die Zufallszahl kleiner als 20 ist, simuliere eine erfolglose Behandlung
						JOptionPane.showMessageDialog(view, patname + " ist gestorben.\nBeweismittel zerstören.",
								"Information", JOptionPane.INFORMATION_MESSAGE);
						if (behandelt instanceof Patient) {
							// Wenn das Objekt eine Instanz von Patient ist, caste es zu Patient und
							// entferne die Details des Patienten aus der View und der Patientenliste
							Patient patient = (Patient) behandelt;
							view.removePatient(behandelt);
							patients.remove(patient.getPatientId() - 1);
						} else {
							// Implementierung für weitere Instanzen
						}

					} else {
						// Wenn die Zufallszahl größer oder gleich wie die chance ist, simuliere eine
						// erfolgreiche Behandlung
						JOptionPane.showMessageDialog(null,
								patname + " ist am Leben.\nWir haben nichts mit dem Organhandel zu tun.", "Information",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					// Wenn sich kein Patient im Wartezimmer befindet, zeige eine Warnung an
					JOptionPane.showMessageDialog(null, "Keine Patienten im Wartezimmer.", "Warnung",
							JOptionPane.INFORMATION_MESSAGE);
				}

				// Aktualisiere die Anzahl der aktuell wartenden Patienten
				if (waitingAnzeige != null) {
					waitingAnzeige.refreshDisplay();
				}

			} else {
				JOptionPane.showMessageDialog(view, "Keine Patienten im Wartezimmer.", "Warnung",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// ActionListener für den "Zur Warteliste hinzufügen"-Button
	private class AddToWaitListListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Wenn der "Zur Warteliste hinzufügen"-Button geklickt wird, füge den
			// ausgewählten Patienten dem
			// Wartezimmer hinzu und zeige eine Warnung, wenn kein Patient ausgewählt ist
			int selectedRow = view.getSelectedRowIndex();
			if (selectedRow != -1) {
				Patient selectedPatient = getSelectedPatient(selectedRow);

				// Füge den ausgewählten Patienten dem Wartezimmer hinzu
				waitingRoom.addPatient(selectedPatient);

				// Überprüfe, ob die Anzeige des Wartezimmers bereits läuft. Wenn nicht, starte
				// sie.
				if (!isWaitingRoomRunning) {
					waitingAnzeige = new Anzeige();
					isWaitingRoomRunning = true;
				}

				// Aktualisiere die Anzeige des Wartezimmers mit den Patienten im Wartezimmer
				waitingAnzeige.addPatient(selectedPatient);
				waitingAnzeige.refreshDisplay();

			} else {
				JOptionPane.showMessageDialog(view, "Bitte wählen Sie einen Patienten aus.", "Warnung",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// Hilfsmethode zum Abrufen des ausgewählten Patienten
	private Patient getSelectedPatient(int selectedRow) {
		// Überprüfe, ob der bereitgestellte Zeilenindex gültig ist, und gib bei Erfolg
		// den Patienten an dieser Position zurück
		if (selectedRow >= 0 && selectedRow < patients.size()) {
			return patients.get(selectedRow);
		} else {
			return null;
		}
	}
}
