import java.io.Serializable;
import java.util.Random;

public class Employee implements Serializable
{
	// VARIABLES TO STORE DETAILS OF AN EMPLOYEE
	private String employeeName;
	private String email;
	private String emptype;
	private String designation;
	private String eid;
	private static float hrs;
	
	protected Employee()
	{
		
	}


	// THIS CONSTUCTOR IS CREATED TO INITIALIZE  THE DETAILS OF A PART TIME EMPLOYEE 
	protected Employee(String employeeName, String email, String designation, String emptype)
	{
		
		this.employeeName = employeeName;
		this.email = email;
		this.emptype = emptype;
		this.eid = employeeName.substring(0,3) + generateID();
		this.designation = designation;
		//this.hrs=hrs;
		
	}

    public int generateID()
    {	int randNum;
        Random rand = new Random();
        randNum = rand.nextInt(100);
        return randNum;
    }
		
	
public String getEid() 
{
	return eid;
}


public void setEid(String eid) 
{
	this.eid = eid;
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


public String getEmptype() 
{
	return emptype;
}


public void setEmptype(String emptype) 
{
	this.emptype = emptype;
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
	
	if(emptype.toUpperCase().equals("FULL TIME"))
	{
		return "Employee name" + ":" + employeeName +"\n " + "Employee email" + ":"+ email + "\n" + "Employee type" + " :"
				+ emptype + "\n" + " Employee address" +" :" +"\n" + " Employee id" + ":" + eid + "\n ";
	}
	else
	{
		return "Employee name" + ":" + employeeName +"\n " + "Employee email" + ":"+ email + "\n" + "Employee type" + " :"
				+ emptype + "\n" + " Employee id" + ":" + eid + "\n"+ "Hours Worked"+ ":"+hrs;


	}


}



}
