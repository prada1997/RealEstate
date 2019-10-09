import java.io.Serializable;
import java.util.Random;

public abstract class Customer implements Serializable
{
	private String customerName;
	private String emailID;	
	private String customerType;
	private String customerId;

	protected Customer() {

	}


	protected Customer(String customerName,String emailID,String customerType) {
		this.customerName = customerName;
		this.emailID = emailID;
		this.customerType = customerType;
		this.customerId = customerType.substring(0,3)+generateID();
	}


	public int generateID()
	{	int randNum;
		Random rand = new Random();
		randNum = rand.nextInt(100);
		return randNum;
	}
	
	public String ShowDetails() 
	{
		String details = "customerName =" + customerName +
						"\nemailID =" + emailID +
						"\ncustomerType =" + customerType +
						"\nuniqueID =" + customerId;
	
		return details;
	}

	
	public String getCustomerId() {
		return customerId;
	}
	
	public String getCustomerType() {
		return customerType;
	}

	public String getEmailID() {
		return emailID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerId (String customerId) {
		this.customerId = customerId;
	}
}
