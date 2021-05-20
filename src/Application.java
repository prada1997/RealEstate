import java.io.Serializable;
import java.util.Scanner;

public class Application implements Serializable
{
	private double offerAmount;
	private double income;
	private String PastOccupation;
	private String CurrentOccupation;
	private double PastRental;
	private double CurrentRental;
	private String customerID;
	private String propertyName;
	private String applicationStatus;

	public String getPropertyName() {
		return propertyName;
	}

	public Application(String customerID, String propertyName, double income, String PastOccupation, String CurrentOccupation, double PastRental, double CurrentRental)
	{
		this.customerID = customerID;
		this.income = income;
		this.PastOccupation = PastOccupation;
		this.CurrentOccupation = CurrentOccupation;
		this.PastRental = PastRental;
		this.CurrentRental = CurrentRental;
		this.propertyName = propertyName;
		applicationStatus = "Decision Pending";
	}

	public Application(String customerID, String propertyName, double income, String CurrentOccupation, double offerAmount)
	{
		this.customerID = customerID;
		this.income = income;
		this.CurrentOccupation = CurrentOccupation;
		this.propertyName = propertyName;
		applicationStatus = "Decision Pending";
		this.offerAmount = offerAmount;
	}



	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}
	
	public String tenantApplicationDisplay(){

		String details = "\n" + 
						 "Income: " + income + "\n" 
						 + "Past Occupation: " + PastOccupation + "\n"
						 + "Current Occupation: " + CurrentOccupation + "\n"
						 + "Past Rental: " + PastOccupation + "\n" 
						 + "Current Rental: " + CurrentOccupation + "\n";
		return details;
	}

	public String buyerApplicationDisplay(){

		String details = "\n" +
				"Income: " + income + "\n"
				+ "Current Occupation: " + CurrentOccupation + "\n"
				+ "Offer Amount: " + offerAmount + "\n";
		return details;
	}
	
}
