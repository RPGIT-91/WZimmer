//noch nicht implementiert
//Wartezimmer Klasse. Hier sollen Patienten und angestellte aus der DB zum Display im Wartezimmer hinzugefügt werden.
//Linked Lists benutzen

//test Ryu
package gui;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JOptionPane;

import user.Patient;

public class WaitingRoom {
    private Queue<Patient> patientsWaitroom;
    private Patient behandelt;

    public WaitingRoom() {
    	// LinkedList implementation of Queue
    	patientsWaitroom = new LinkedList<>();
    }

    public void addPatient(Patient patient) {
    	if (!patientsWaitroom.contains(patient)) {
            patientsWaitroom.add(patient);
        } else {
            int option = JOptionPane.showOptionDialog(null, "Patient already in the waitroom. Add anyway?", "Duplicate Entry", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option == JOptionPane.YES_OPTION) {
                patientsWaitroom.add(patient);
                // You can display an error message or handle it as per your application's requirements
                }
        }
    }

    public void removePatient(Patient patient) {
    	patientsWaitroom.remove(patient);
    }

    public Queue<Patient> getPatients() {
        return patientsWaitroom;
    }

    
    public Patient doTreatment() {
        if (!patientsWaitroom.isEmpty()) {
            behandelt = patientsWaitroom.poll(); // Remove and retrieve the first patient from the waitroom
            
            return behandelt;
        } else {
        	return null;
        }

    }
}