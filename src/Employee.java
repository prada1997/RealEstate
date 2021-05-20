import java.io.Serializable;
import java.util.Random;

public abstract class Employee implements Serializable
{
	// VARIABLES TO STORE DETAILS OF AN EMPLOYEE
	private String employeeName;
	private String email;
	private String employeeType;
	private String designation;
	private String employeeID;
	private double Salary;
	private boolean isAssign;
	private double workingHour;

	protected Employee()
	{
		
	}

	public double getWorkingHour() {
		return workingHour;
	}

	protected Employee(String employeeName, String email, String designation, String empType)
	{
		
		this.employeeName = employeeName;
		this.email = email;
		this.employeeType = empType;
		if(empType.equals("full time")){
			workingHour = 80;
		}
		this.employeeID = employeeName.substring(0,3) + generateID();
		this.designation = designation;
		isAssign = false;
	}

    public int generateID()
    {	int randNum;
        Random rand = new Random();
        randNum = rand.nextInt(100);
        return randNum;
    }

	public void setSalary(double salary) {
		Salary = salary;
	}

	public String getEmployeeID()
{
	return employeeID;
}

	public boolean isAssign() {
		return isAssign;
	}

	public void setEmployeeID(String employeeID)
{
	this.employeeID = employeeID;
}


public String getEmployeeName()
{
	return employeeName;
}


public void setEmployeeName(String employeeName)
{
	this.employeeName = employeeName;
}


public String getEmail() 
{
	return email;
}


public void setEmail(String email) 
{
	this.email = email;
}


public String getEmployeeType()
{
	return employeeType;
}


public void setEmployeeType(String employeeType)
{
	this.employeeType = employeeType;
}


public String getDesignation() {
	return designation;
}


public void setDesignation(String designation) {
	this.designation = designation;
}


//METHOD TO GET THE DETAILS OF THE EMPLOYEE

public String getDetails()
{
		return "Employee name" + ": " + employeeName +"\n " + "Employee email" + ": "+ email + "\n" + "Employee type" + " : "
				+ employeeType + "\n" + " Employee id" + ": " + employeeID + "\n"+ "Salary: " + Salary;


	}


}

