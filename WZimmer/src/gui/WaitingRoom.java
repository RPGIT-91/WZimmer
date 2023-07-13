//noch nicht implementiert
//Wartezimmer Klasse. Hier sollen Patienten und angestellte aus der DB zum Display im Wartezimmer hinzugefügt werden.
//Linked Lists benutzen

//test Ryu
package gui;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import user.Employee;
import user.Patient;

public class WaitingRoom {
    //private Queue<Patient> patientsWZ
    private List<Employee> doctorsAvailable;
    private Queue<Patient> patientsWaitroom;

    public WaitingRoom() {
    	// LinkedList implementation of Queue
    	patientsWaitroom = new LinkedList<>();
        doctorsAvailable = new LinkedList<>();
        
    }

    public void addPatient(Patient patient) {
    	patientsWaitroom.add(patient);
    }

    public void removePatient(Patient patient) {
    	patientsWaitroom.remove(patient);
    }

    public void addEmployee(Employee employee) {
        doctorsAvailable.add(employee);
    }

    public void removeEmployee(Employee employee) {
    	doctorsAvailable.remove(employee);
    }

    public Queue<Patient> getPatients() {
        return patientsWaitroom;
    }

    public List<Employee> getEmployees() {
        return doctorsAvailable;
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