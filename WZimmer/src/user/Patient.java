package user;
public class Patient extends Person {
private String medicalHistory;
private String appointmentTime;
private int patientId;

public Patient(String name, int age, String contactDetails, String medicalHistory, String appointmentTime) {
	super(name, age, contactDetails);
	this.medicalHistory = medicalHistory;
	this.appointmentTime = appointmentTime;
	}

public Patient(String name, int age, String contactDetails, String medicalHistory) {
	super(name, age, contactDetails);
	this.medicalHistory = medicalHistory;
	this.appointmentTime = "";
	}

    // Getters and setters for patient-specific attributes
public String getMedicalHistory() {
	return medicalHistory;
	}

public void setMedicalHistory(String medicalHistory) {
	this.medicalHistory = medicalHistory;
	}

public String getAppointmentTime() {
	return appointmentTime;
	}

public void setAppointmentTime(String appointmentTime) {
	this.appointmentTime = appointmentTime;
    }
public int getPatientId() {
    return patientId;
}

public void setPatientId(String patientId) {
    this.patientId = Integer.parseInt(patientId);
}

/*public Object[] prepPatient() {
	Object[] array = new Object[{Patient.getName(), Patient.getAge(), Patient.getAppointmentTime()}];
	return array;
	}*/
}