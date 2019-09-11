import java.util.Scanner;

public class Application 
{
	double income;
	String PastOccupation;
	String CurrentOccupation;
	int PastRental;
	int CurrentRental;
	
	public Application(double income, String PastOccupation, String CurrentOccupation, int PastRental,int CurrentRental) 
	{
		this.income = income;
		this.PastOccupation = PastOccupation;
		this.CurrentOccupation = CurrentOccupation;
		this.PastRental = PastRental;
		this.CurrentRental = CurrentRental;
	}
	
//	public void Pastoccupation() 
//	{
//		
//	}
	
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
