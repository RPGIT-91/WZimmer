// This is the Person class that serves as a base class for other classes such as Patient and Employee.
// The 'package user' line means that this class is part of the 'user' package.
package user;

// The Person class is not public, which means it is package-private by default. This means that it can only be accessed from within its own package.
class Person {
    // These are the instance variables of the Person class.
    private String name;
    private int age;
    private String contactDetails;
    private String adress;
    private String plz; // This seems to stand for postal code (Postleitzahl in German)
    private String telephone;

    // This is the constructor for the Person class. It is called when a new instance of the Person class is created.
    public Person(String name, int age, String contactDetails, String adress, String plz, String telephone) {
        this.name = name; // 'this' refers to the current object. It is used to access the class's instance variables.
        this.age = age;
        this.contactDetails = contactDetails;
        this.adress = adress;
        this.plz = plz;
        this.telephone = telephone;
    }

    // These are getter methods. They are used to retrieve the value of private instance variables from outside the class.
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

    // These are setter methods. They are used to set the value of private instance variables from outside the class.
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
