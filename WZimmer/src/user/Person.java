//Person Klasse

package user;

class Person {
    private String name;
    private int age;
    private String contactDetails;
    private String adress;
    private int plz;
    private String telephone;

    public Person(String name, int age, String contactDetails, String adress, int plz, String telephone) {
        this.name = name;
        this.age = age;
        this.contactDetails = contactDetails;
        this.adress = adress;
        this.plz = plz;
        this.telephone = telephone;
    }

    // Getters
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

    public int getPlz() {
        return plz;
    }

    public String getTelephone() {
        return telephone;
    }



    // Setters
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

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}