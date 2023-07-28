package gui;
import java.util.Queue;

import user.Patient;

interface IWaitingRoomOperations {
    void addPatient(Patient patient);
    void removePatient(Patient patient);
    Patient doTreatment();
    Queue<Patient> getPatients();
}