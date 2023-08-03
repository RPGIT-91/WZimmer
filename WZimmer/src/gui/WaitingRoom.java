// Die Klasse "WaitingRoom" dient dazu, ein Wartezimmer zu modellieren, in dem Patienten mit einer Queue hinzugefügt oder entfernt werden können.

package gui;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import interfaces.IWaitingRoomOperations;
import user.*;

class WaitingRoom implements IWaitingRoomOperations {
	private Queue<Person> patientsWaitroom;
	private Person behandelt;

	// Konstruktor der Klasse "WaitingRoom"
	public WaitingRoom() {
		// Initialisiere die Wartezimmer-Warteschlange als eine LinkedList von Personen.
		patientsWaitroom = new LinkedList<>();
	}

	// Methode, um einen Patienten zum Wartezimmer hinzuzufügen
	@Override
	public void addPatient(Person patient) {
		// Überprüfe, ob der Patient bereits im Wartezimmer ist
		if (!patientsWaitroom.contains(patient)) {
			// Wenn der Patient noch nicht im Wartezimmer ist, füge ihn hinzu
			patientsWaitroom.add(patient);
		} else {
			// Wenn der Patient bereits im Wartezimmer ist, frage den Benutzer, ob der
			// Patient trotzdem hinzugefügt werden soll.
			int option = JOptionPane.showOptionDialog(null, "Patient ist bereits im Wartezimmer. Trotzdem hinzufügen?",
					"Doppelte Eingabe", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (option == JOptionPane.YES_OPTION) {
				// Wenn der Benutzer "Ja" auswählt, füge den Patienten hinzu.
				patientsWaitroom.add(patient);
			}
		}
	}

	// Methode, um einen Patienten aus dem Wartezimmer zu entfernen
	@Override
	public void removePatient(Person patient) {
		// Entferne den Patienten aus der Warteschlange.
		patientsWaitroom.remove(patient);
	}

	// Methode, um die Behandlung des nächsten Patienten im Wartezimmer
	// durchzuführen
	@Override
	public Person doTreatment() {
		// Überprüfe, ob das Wartezimmer nicht leer ist
		if (!patientsWaitroom.isEmpty()) {
			// Wenn das Wartezimmer nicht leer ist, hole den nächsten Patienten aus der
			// Warteschlange und markiere ihn als behandelt.
			behandelt = patientsWaitroom.poll();
			return behandelt;
		} else {
			// Wenn das Wartezimmer leer ist, gibt es keinen Patienten zu behandeln, daher
			// wird null zurückgegeben.
			return null;
		}
	}

	// Methode, um die Liste der Personen im Wartezimmer zurückzugeben
	@Override
	public Queue<Person> getPersons() {
		// Gib die Warteschlange der Personen im Wartezimmer zurück.
		return patientsWaitroom;
	}
}
