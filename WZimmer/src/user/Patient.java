// This is the Patient class which represents a patient in the system.
// The 'package user' line indicates that this class is part of the 'user' package.
package user;

// The Patient class extends the Person class, which means it inherits all of the variables and methods of the Person class.
// In addition to the inherited attributes, a Patient has a medical history, appointment time, insurance number, insurance institute, and patient ID.
public class Patient extends Person {
    private String medicalHistory;
    private String appointmentTime;
    private String insuranceNo;
    private String insuranceInstitute;
    private int patientId;

    // Constructor for the Patient class with appointment time. When a new Patient object is created, this constructor is called.
    // The constructor takes several parameters: the patient's name, age, contact details, adress, postal code (plz), telephone number, insurance number, insurance institute, medical history, appointment time, and patient ID.
    public Patient(String name, int age, String contactDetails, String adress, String plz, String telephone, String insuranceNo,
                   String insuranceInstitute, String medicalHistory, String appointmentTime, int patientId) {
        super(name, age, contactDetails, adress, plz, telephone); // Calling the constructor of the parent class (Person)
        this.medicalHistory = medicalHistory;
        this.appointmentTime = appointmentTime;
        this.insuranceNo = insuranceNo;
        this.insuranceInstitute = insuranceInstitute;
        this.patientId = patientId;
    }

    // Constructor for the Patient class without appointment time. This one sets the appointment time to an empty string by default.
    public Patient(String name, int age, String contactDetails, String adress, String plz, String telephone, String insuranceNo,
                   String insuranceInstitute, String medicalHistory, int patientId) {
        super(name, age, contactDetails, adress, plz, telephone); // Calling the constructor of the parent class (Person)
        this.medicalHistory = medicalHistory;
        this.appointmentTime = ""; // No appointment time specified
        this.insuranceNo = insuranceNo;
        this.insuranceInstitute = insuranceInstitute;
        this.patientId = patientId;
    }

    // Empty constructor for the Patient class. This creates a "default" patient with no details and a placeholder patient ID.
    public Patient() {
        super("", 0, "", "", "", ""); // Calling the constructor of the parent class (Person) with default values
        this.medicalHistory = "";
        this.appointmentTime = "";
        this.insuranceNo = "";
        this.insuranceInstitute = "";
        this.patientId = 9999; // Placeholder patient ID
    }

    // Getter methods for the class variables. These allow you to retrieve the values of these variables from an instance of the class.
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public String getInsuranceInstitute() {
        return insuranceInstitute;
    }

    // Setter methods for the class variables. These allow you to change the values of these variables for an instance of the class.
    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public void setInsuranceInstitute(String insuranceInstitute) {
        this.insuranceInstitute = insuranceInstitute;
    }

    /*public Object[] prepPatient() {
        Object[] array = new Object[{Patient.getName(), Patient.getAge(), Patient.getAppointmentTime()}];
        return array;
    }*/
}
