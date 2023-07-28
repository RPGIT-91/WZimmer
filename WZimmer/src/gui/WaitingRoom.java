// The WaitingRoom class will serve to model a waiting room where patients are added or removed, using a Queue.
package gui;
// Import required Java classes. LinkedList and Queue from java.util package, JOptionPane from javax.swing for dialogue boxes, and Patient from user package.
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import user.Patient;

public class WaitingRoom implements IWaitingRoomOperations {
    private Queue<Patient> patientsWaitroom;
    private Patient behandelt;

    public WaitingRoom() {
        patientsWaitroom = new LinkedList<>();
    }

    @Override
    public void addPatient(Patient patient) {
        if (!patientsWaitroom.contains(patient)) {
            patientsWaitroom.add(patient);
        } else {
            int option = JOptionPane.showOptionDialog(null, "Patient already in the waitroom. Add anyway?", "Duplicate Entry", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option == JOptionPane.YES_OPTION) {
                patientsWaitroom.add(patient);
            }
        }
    }

    @Override
    public void removePatient(Patient patient) {
        patientsWaitroom.remove(patient);
    }

    @Override
    public Patient doTreatment() {
        if (!patientsWaitroom.isEmpty()) {
            behandelt = patientsWaitroom.poll();
            return behandelt;
        } else {
            return null;
        }
    }

    public Queue<Patient> getPatients() {
        return patientsWaitroom;
    }
}


