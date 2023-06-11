//noch nicht implementiert
//Wartezimmer Klasse. Hier sollen Patienten und angestellte aus der DB zum Display im Wartezimmer hinzugefügt werden.
//Linked Lists benutzen
package gui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import user.Employee;
import user.Patient;

public class WaitingRoom {
    //private Queue<Patient> patientsWZ
    private List<Employee> employeesWZ;
    private Queue<Patient> patientsWaitroom;

    public WaitingRoom() {
        //patientsWZ = new ArrayList<>();
        employeesWZ = new ArrayList<>();
        
        patientsWaitroom = new LinkedList<>();
        
    }

    public void addPatient(Patient patient) {
    	patientsWaitroom.add(patient);
    }

    public void removePatient(Patient patient) {
    	patientsWaitroom.remove(patient);
    }

    public void addEmployee(Employee employee) {
        employeesWZ.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeesWZ.remove(employee);
    }

    public Queue<Patient> getPatients() {
        return patientsWaitroom;
    }

    public List<Employee> getEmployees() {
        return employeesWZ;
    }
}