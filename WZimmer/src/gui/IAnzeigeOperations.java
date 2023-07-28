// Anzeige Interface
package gui;

import javax.swing.JPanel;
import user.Patient;

public interface IAnzeigeOperations {
    void addPatient(Patient patient);
    void removePatient(Patient patient);
    JPanel getWaitPanel();
    int getRows();
}