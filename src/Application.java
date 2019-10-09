import java.io.Serializable;
import java.util.Scanner;

public class Application implements Serializable
{
	//int to double
	double income;
	String PastOccupation;
	String CurrentOccupation;
	double PastRental;
	double CurrentRental;
	String customerID;
	String propertyName;
	String applicationStatus;
	
	public Application(String customerID, String propertyName, double income, String PastOccupation, String CurrentOccupation, double PastRental, double CurrentRental)
	{
		this.customerID = customerID;
		this.income = income;
		this.PastOccupation = PastOccupation;
		this.CurrentOccupation = CurrentOccupation;
		this.PastRental = PastRental;
		this.CurrentRental = CurrentRental;
		applicationStatus = "Decision Pending";
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void Pastoccupation()
	{

	}
	
	
	public String display(){
		String details = "\n" + 
						 "Income: " + income + "\n" 
						 + "Past Occupatiion: " + PastOccupation + "\n" 
						 + "Curent Occupation: " + CurrentOccupation + "\n" 
						 + "Past Rental: " + PastOccupation + "\n" 
						 + "Current Rental: " + CurrentOccupation + "\n";
		return details;
	}
	
}
