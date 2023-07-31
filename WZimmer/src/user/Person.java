package user;

public abstract class Person {
    // These are the instance variables of the Person class.
    protected String name;
    protected int age;
    protected String contactDetails;
    protected String adress;
    protected String plz;
    protected String telephone;

    // This is the constructor for the Person class. It is called when a new instance of the Person class is created.
    public Person(String name, int age, String contactDetails, String adress, String plz, String telephone) {
        this.name = name;
        this.age = age;
        this.contactDetails = contactDetails;
        this.adress = adress;
        this.plz = plz;
        this.telephone = telephone;
    }

    // Abstract getters (w/o implementation)
    public abstract String getName();
    public abstract int getAge();
    public abstract String getContactDetails();
    public abstract String getAdress();
    public abstract String getPlz();
    public abstract String getTelephone();

    // Abstract setters (w/o implementation)
    public abstract void setName(String name);
    public abstract void setAge(int age);
    public abstract void setContactDetails(String contactDetails);
    public abstract void setAdress(String adress);
    public abstract void setPlz(String plz);
    public abstract void setTelephone(String telephone);
}