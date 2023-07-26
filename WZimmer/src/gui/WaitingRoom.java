// The WaitingRoom class will serve to model a waiting room where patients are added or removed, using a Queue.
package gui;
// Import required Java classes. LinkedList and Queue from java.util package, JOptionPane from javax.swing for dialogue boxes, and Patient from user package.
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import user.Patient;

public class WaitingRoom {
    // Declare a Queue of patients for the waiting room. A Queue is a collection designed for holding elements prior to processing. It follows the FIFO (First In First Out) principle.
    private Queue<Patient> patientsWaitroom;
    // Declare a Patient variable 'behandelt' which refers to the patient that is currently being treated.
    private Patient behandelt;

    // Define the constructor for the WaitingRoom class.
    public WaitingRoom() {
        // Initialize the patientsWaitroom with a LinkedList. LinkedLists are beneficial for queue implementations as they provide efficient operations for insertion or deletion.
        patientsWaitroom = new LinkedList<>();
    }

    // Define a method to add a patient to the queue. If the patient already exists in the queue, ask the user whether they want to add the patient anyway.
    public void addPatient(Patient patient) {
        if (!patientsWaitroom.contains(patient)) {
            patientsWaitroom.add(patient);  // If the patient doesn't already exist in the queue, add them.
        } else {
            // If the patient is already in the queue, show a dialogue box asking the user if they want to add the patient anyway.
            int option = JOptionPane.showOptionDialog(null, "Patient already in the waitroom. Add anyway?", "Duplicate Entry", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option == JOptionPane.YES_OPTION) {
                // If the user selects 'YES', add the patient to the queue anyway.
                patientsWaitroom.add(patient);
            }
        }
    }

    // Define a method to remove a patient from the queue.
    public void removePatient(Patient patient) {
        patientsWaitroom.remove(patient);
    }

    // Define a method to get all patients from the queue.
    public Queue<Patient> getPatients() {
        return patientsWaitroom;
    }

    // Define a method to treat the first patient in the queue. If the queue is empty, return null. Otherwise, remove the first patient from the queue and return them.
    public Patient doTreatment() {
        if (!patientsWaitroom.isEmpty()) {
            behandelt = patientsWaitroom.poll(); // Remove and retrieve the first patient from the waitroom
            return behandelt;
        } else {
            return null; // If there are no patients in the waitroom, return null.
        }
    }
}
