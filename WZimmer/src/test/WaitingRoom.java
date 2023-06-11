package test;

import java.util.ArrayList;
import java.util.List;

class WaitingRoom {
    private List<Patient> patients;
    private List<Employee> employees;

    public WaitingRoom() {
        patients = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}