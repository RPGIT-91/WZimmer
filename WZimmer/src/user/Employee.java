// This is the Employee class which represents an employee in the system.
// The 'package user' line indicates that this class is part of the 'user' package.

package user;

// The Employee class extends the Person class, which means it inherits all of the variables and methods of the Person class.
// In addition to the inherited attributes, an Employee has a jobTitle and an employeeID.
public class Employee extends Person {
    // Declare variables for the job title and employee ID. These are additional attributes that are specific to an employee.
    private String jobTitle;
    private int employeeID;

    // This is the constructor for the Employee class. When a new Employee object is created, this constructor is called.
    // The constructor takes several parameters: the employee's name, age, contact details, adress, postal code (plz), telephone number, job title, and employee ID.
    public Employee(String name, int age, String contactDetails, String adress, String plz, String telephone, String jobTitle, int employeeID) {
        // The 'super' keyword is used to call the constructor of the parent class (Person). 
        // This is needed because the Employee class extends the Person class.
        super(name, age, contactDetails, adress, plz, telephone);
        
        // Set the job title and employee ID of the employee.
        this.jobTitle = jobTitle;
        this.employeeID = employeeID;
    }

    // This is a 'getter' method which returns the job title of the employee.
    public String getJobTitle() {
        return jobTitle;
    }

    // This is a 'setter' method which sets the job title of the employee.
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    // This is a 'getter' method which returns the employee ID.
    public int getEmployeeID() {
        return employeeID;
    }

    // This is a 'setter' method which sets the employee ID. 
    // It takes a String as an input and converts it to an integer using Integer.parseInt().
    public void setEmployeeID(String employeeID) {
        this.employeeID = Integer.parseInt(employeeID);
    }
}
