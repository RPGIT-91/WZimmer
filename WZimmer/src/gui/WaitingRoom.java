//noch nicht implementiert
//Wartezimmer Klasse. Hier sollen Patienten und angestellte aus der DB zum Display im Wartezimmer hinzugefügt werden.
//Linked Lists benutzen

//test Ryu
package gui;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JOptionPane;

import user.Patient;

public class WaitingRoom {
    private Queue<Patient> patientsWaitroom;

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

    
    public void doTreatment(String treatment) {
        if (!patientsWaitroom.isEmpty()) {
            Patient patient = patientsWaitroom.poll(); // Remove and retrieve the first patient from the waitroom
            System.out.print("Treating patient: " + patient.getName() + ", Treatment: " + treatment);
            
            // Generate a random number between 0 and 99
            Random random = new Random();
            int chance = random.nextInt(100);
            
            if (chance < 5) {
                System.out.println(" [Treatment went wrong]");
                
                // Handle the treatment going wrong
            } else {
                System.out.println(" [Treatment successful]");
                // Handle the successful treatment
            }
        } else {
            System.out.println("No patients in the waitroom.");
        }
    }
}