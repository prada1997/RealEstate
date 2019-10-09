import java.io.Serializable;
import java.util.Scanner;

public class Rental extends Property implements Serializable
{
	private double  ManagementFee;
	private double RentalAmt;
	private double CDuration;
	
	
	
	public Rental(String customerID, String propertyName, String address, String suburb, String capacity, String type, double Mfee, double RAmt, double Dur)
	{
		super(customerID,propertyName, address, suburb, capacity, type);
		this.ManagementFee = Mfee;
		this.RentalAmt = RAmt;
		this.CDuration = Dur;
	}

//	public void SetAgent(PropertyManager Emp) 
//	{
//		this.Emp = Emp;
//		IsAssign = true;
//	}

	public boolean formalOffer()
	{
		String decision;
		int num = 1;
		System.out.println("Select Application for the property. /n Type number");
		for(int i : getApplication().keySet())
		{
			System.out.print("Application " + num + ":");
			System.out.print(getApplication().get(i).display());
			System.out.println("\n");
			num++;
		}

		System.out.print("To select application enter application ID:");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();

		if(getApplication().containsKey(choice)){
			System.out.println("Please enter the Decision i.e. Accept or Reject");
			decision = new Scanner(System.in).next();
			getApplication().get(choice).setApplicationStatus(decision);
			setPropertyStatus("Sold");
		}
		else {
			formalOffer();
		}

		return true;
	}


	public void AddInspections() 
	{
		
	}
	
//	public String ShowInspections() 
//	{
//		
//	}
	
	
}
