
public class Employee 
{
	
	// VARIABLES TO STORE DETAILS OF AN EMPLOYEE
	String ename;
	String email;
	String emptype;
	String address;
	String designation;
	long mobno;
	String eid;
	static float hrs;
	
	public Employee()
	{
		
	}
	
	
	//THIS CONSTRUCTOR IS CREATED TO INITIALIZE THE DETAILS OF A FULL TIME EMPLOYEE
	public Employee(String ename, String eid, String emptype,String designation,String address, long mobno, String email) 
	{
		
		this.ename = ename;
		this.email = email;
		this.emptype = emptype;
		this.address = address;
		this.mobno = mobno;
		this.eid = eid;
		this.designation=designation;
		
	}


	// THIS CONSTUCTOR IS CREATED TO INITIALIZE  THE DETAILS OF A PART TIME EMPLOYEE 
	public Employee(String ename, String eid, String emptype, String designation, String address, long mobno, String email,float hrs) 
	{
		
		this.ename = ename;
		this.email = email;
		this.emptype = emptype;
		this.address = address;
		this.mobno = mobno;
		this.eid = eid;
		this.designation=designation;
		this.hrs=hrs;
		
	}

		
	
public String getEid() 
{
	return eid;
}


public void setEid(String eid) 
{
	this.eid = eid;
}


public String getEname() 
{
	return ename;
}


public void setEname(String ename) 
{
	this.ename = ename;
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


public String getAddress() 
{
	return address;
}


public void setAddress(String address) 
{
	this.address = address;
}


public long getMobno() 
{
	return mobno;
}


public void setMobno(long mobno) 
{
	this.mobno = mobno;
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
		return "Employee name" + ":" + ename +"\n " + "Employee email" + ":"+ email + "\n" + "Employee type" + " :" + emptype + "\n" + " Employee address"
		+" :"+ address +"\n" + " Employee id" + ":" + eid + "\n " + " Employee Mobileno" + ":" +mobno; 
	}
	else
	{
		return "Employee name" + ":" + ename +"\n " + "Employee email" + ":"+ email + "\n" + "Employee type" + " :" + emptype + "\n" + " Employee address"
			+" :"+ address +"\n" + " Employee id" + ":" + eid + "\n " + " Employee Mobileno" + ":" +mobno +"\n"+ "Hours Worked"+ ":"+hrs; 


	}


}



}
