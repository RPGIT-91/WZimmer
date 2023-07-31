package user;

// Die Patient-Klasse repräsentiert einen Patienten im System und erbt von der Person-Klasse.
// Ein Patient hat zusätzlich zu den geerbten Attributen einen medizinischen Verlauf, eine Terminzeit, Versicherungsnummer, Versicherungsinstitut und eine Patienten-ID.
public class Patient extends Person {
	private String medicalHistory;
	private String appointmentTime;
	private String insuranceNo;
	private String insuranceInstitute;
	private int patientId;

	// Konstruktor für die Patient-Klasse mit Terminzeit.
	public Patient(String name, int age, String contactDetails, String adress, String plz, String telephone,
			String insuranceNo, String insuranceInstitute, String medicalHistory, String appointmentTime,
			int patientId) {
		super(name, age, contactDetails, adress, plz, telephone);
		this.medicalHistory = medicalHistory;
		this.appointmentTime = appointmentTime;
		this.insuranceNo = insuranceNo;
		this.insuranceInstitute = insuranceInstitute;
		this.patientId = patientId;
	}

	// Konstruktor für die Patient-Klasse ohne Terminzeit. Wird nicht genutzt, da im
	// addPatient, eine unbefüllte oder falsch formatierte
	// Eingabe automatisch auf 0 gesetzt wird. Future proofing.
	public Patient(String name, int age, String contactDetails, String adress, String plz, String telephone,
			String insuranceNo, String insuranceInstitute, String medicalHistory, int patientId) {
		super(name, age, contactDetails, adress, plz, telephone);
		this.medicalHistory = medicalHistory;
		this.appointmentTime = "";
		this.insuranceNo = insuranceNo;
		this.insuranceInstitute = insuranceInstitute;
		this.patientId = patientId;
	}

	// Leerer Konstruktor für die Patient-Klasse. Erzeugt einen "Standard"-Patienten
	// ohne Details und eine Platzhalter-Patienten-ID.
	public Patient() {
		super("", 0, "", "", "", "");
		this.medicalHistory = "";
		this.appointmentTime = "";
		this.insuranceNo = "";
		this.insuranceInstitute = "";
		this.patientId = 9999;
	}

	// Getter-Methoden für die Klassenvariablen.
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

	// Setter-Methoden für die Klassenvariablen.
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

	// Implementierung der geerbten abstrakten Methoden aus der Person-Klasse
	@Override
	public String getName() {
		return super.name;
	}

	@Override
	public int getAge() {
		return super.age;
	}

	@Override
	public String getContactDetails() {
		return super.contactDetails;
	}

	@Override
	public String getAdress() {
		return super.adress;
	}

	@Override
	public String getPlz() {
		return super.plz;
	}

	@Override
	public String getTelephone() {
		return super.telephone;
	}

	// Setter-Methoden für die geerbten abstrakten Methoden aus der Person-Klasse
	public void setName(String name) {
		super.name = name;
	}

	public void setAge(int age) {
		super.age = age;
	}

	public void setContactDetails(String contactDetails) {
		super.contactDetails = contactDetails;
	}

	public void setAdress(String adress) {
		super.adress = adress;
	}

	public void setPlz(String plz) {
		super.plz = plz;
	}

	public void setTelephone(String telephone) {
		super.telephone = telephone;
	}
}
