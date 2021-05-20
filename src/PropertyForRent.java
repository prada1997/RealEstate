import java.io.Serializable;
import java.util.Scanner;

public class PropertyForRent extends Property implements Serializable
{
	private double  ManagementFee;
	private double rentalAmount;
	private double contractDuration;
	
	
	
	public PropertyForRent(String propertyName, String address, String suburb, String capacity, double Mfee, double RAmt, double Dur)
	{
		super(propertyName, address, suburb, capacity);
		this.ManagementFee = Mfee;
		this.rentalAmount = RAmt;
		this.contractDuration = Dur;
	}


	public String applicationOffer()
	{
		String decision = null;
		int num = 1;
		System.out.println("Select Application for the property. \n Type number");
		for(int i : getApplication().keySet())
		{
			System.out.print("Application " + num + ":");
			System.out.print(getApplication().get(i).buyerApplicationDisplay());
			System.out.println("\n");
			num++;
		}

		System.out.print("To select application enter application ID:");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
	do {
		if (getApplication().containsKey(choice)) {
			System.out.println("Please enter the Decision i.e. Accept or Reject");
			decision = new Scanner(System.in).next();
			getApplication().get(choice).setApplicationStatus(decision);
			setPropertyStatus("Payment Awaited");
		}
	} while (!(decision.equals("accept") || decision.equals("reject")));

	return "completed";
	
	}
}
