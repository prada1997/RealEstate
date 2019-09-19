import java.io.IOException;

import java.util.Random;

public class Customer
{
	private String customerName;
	private String emailID;	
	private String customerType;
	private String uniqueID;
	private int randNum;
				
	protected Customer(String customerName,String emailID,String customerType) throws IOException {
		this.customerName = customerName;
		this.emailID = emailID;
		this.customerType = customerType;
		this.uniqueID = customerType.substring(0,3)+generateID();        	
		new Record(this);
	}	
	
	public int generateID() 
	{			
		Random rand = new Random();	 	
		randNum = rand.nextInt(100);
		return randNum;
	}
	
	public String ShowDetails() 
	{
		String details = "customerName =" + customerName +
						"\nemailID =" + emailID +
						"\ncustomerType =" + customerType +
						"\nuniqueID =" + uniqueID;
	
		return details;
	}
	
	public String getUniqueID() {
		return uniqueID;
	}
	
	public String getCustomerType() {
		return customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

}
