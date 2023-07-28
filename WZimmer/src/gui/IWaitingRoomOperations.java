package gui;
import user.Patient;

public interface IWaitingRoomOperations {
    void addPatient(Patient patient);
    void removePatient(Patient patient);
    Patient doTreatment();
}