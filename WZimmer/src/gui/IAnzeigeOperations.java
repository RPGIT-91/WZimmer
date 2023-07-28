// Anzeige Interface
package gui;

import javax.swing.JPanel;
import user.Patient;

interface IAnzeigeOperations {
    void addPatient(Patient patient);
    void removePatient(Patient patient);
    JPanel getWaitPanel();
    int getRows();
}