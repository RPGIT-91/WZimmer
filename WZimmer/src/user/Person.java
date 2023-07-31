package user;

// Abstrakte Klasse, die die Grundstruktur einer Person modelliert.
public abstract class Person {
	// Instanzvariablen, die persönliche Informationen einer Person repräsentieren.
	protected String name;
	protected int age;
	protected String contactDetails;
	protected String adress;
	protected String plz;
	protected String telephone;

	// Konstruktor für die Person-Klasse. Wird aufgerufen, wenn eine neue Instanz
	// der Person-Klasse erstellt wird.
	public Person(String name, int age, String contactDetails, String adress, String plz, String telephone) {
		this.name = name;
		this.age = age;
		this.contactDetails = contactDetails;
		this.adress = adress;
		this.plz = plz;
		this.telephone = telephone;
	}

	// Getter-Methoden mit Default-Implementierung
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public String getAdress() {
		return adress;
	}

	public String getPlz() {
		return plz;
	}

	public String getTelephone() {
		return telephone;
	}

	// Abstrakte Setter-Methoden (ohne Implementierung)
	public abstract void setName(String name);

	public abstract void setAge(int age);

	public abstract void setContactDetails(String contactDetails);

	public abstract void setAdress(String adress);

	public abstract void setPlz(String plz);

	public abstract void setTelephone(String telephone);
}
