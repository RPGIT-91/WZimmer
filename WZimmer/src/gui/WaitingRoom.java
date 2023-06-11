//noch nicht implementiert
//Wartezimmer Klasse. Hier sollen Patienten und angestellte aus der DB zum Display im Wartezimmer hinzugefügt werden.
//Linked List
package gui;

import java.util.ArrayList;
import java.util.List;
import user.Employee;
import user.Patient;

class WaitingRoom {
    private List<Patient> patientsWZ;
    private List<Employee> employeesWZ;

    public WaitingRoom() {
        patientsWZ = new ArrayList<>();
        employeesWZ = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patientsWZ.add(patient);
    }

    public void removePatient(Patient patient) {
        patientsWZ.remove(patient);
    }

    public void addEmployee(Employee employee) {
        employeesWZ.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeesWZ.remove(employee);
    }

    public List<Patient> getPatients() {
        return patientsWZ;
    }

    public List<Employee> getEmployees() {
        return employeesWZ;
    }
}