//Employee Klasse

package user;

public class Employee extends Person {
    private String jobTitle;
    private int employeeID;

    public Employee(String name, int age, String contactDetails, String adress, String plz, String telephone, 
    		String jobTitle, int employeeID) {
		super(name, age, contactDetails, adress, plz, telephone);
        this.jobTitle = jobTitle;
        this.employeeID = employeeID;
    }

    // Getters and setters for employee-specific attributes
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = Integer.parseInt(employeeID);
    }
}
