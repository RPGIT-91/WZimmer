//Patient Klasse

package user;
public class Patient extends Person {
	private String medicalHistory;
	private String appointmentTime;
	private String insuranceNo;
	private String insuranceInstitute;
	private int patientId;
	
	//constructors to add new patient
	//constructor with appointment time
	public Patient(String name, int age, String contactDetails, String adress, int plz, String telephone, String insuranceNo,
			String insuranceInstitute, String medicalHistory, String appointmentTime, int patientId) {
		super(name, age, contactDetails, adress, plz, telephone);
		this.medicalHistory = medicalHistory;
		this.appointmentTime = appointmentTime;
		this.insuranceNo = insuranceNo;
		this.insuranceInstitute = insuranceInstitute;
		this.patientId = patientId;
	}
	
	//constructor without appointment time
	public Patient(String name, int age, String contactDetails, String adress, int plz, String telephone, String insuranceNo,
			String insuranceInstitute, String medicalHistory, int patientId) {
		super(name, age, contactDetails, adress, plz, telephone);
		this.medicalHistory = medicalHistory;
		this.appointmentTime = "";
		this.insuranceNo = insuranceNo;
		this.insuranceInstitute = insuranceInstitute;
		this.patientId = patientId;
	}
	
	
	
	// Getters
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

    
    // Setters
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
