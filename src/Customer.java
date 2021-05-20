import java.io.Serializable;
import java.util.Random;

public abstract class Customer implements Serializable
{
	private String customerName;
	private String emailID;
	private String customerId;
	private String customerType;
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



	public String getCustomerId() {
		return customerId;
	}

	public String getEmailID() {
		return emailID;
	}

	public String getCustomerType() {
		return customerType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerId (String customerId) {
		this.customerId = customerId;
	}

}
