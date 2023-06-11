package test;

class Person {
    private String name;
    private int age;
    private String contactDetails;

    public Person(String name, int age, String contactDetails) {
        this.name = name;
        this.age = age;
        this.contactDetails = contactDetails;
    }

    // Getters and setters for common attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}