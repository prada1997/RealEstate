import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;

public class Sales extends Property implements Serializable
{
	private double minprice;
	private double DownPayment = minprice * 0.1;


	public Sales(String customerID,String propertyName, String address, String suburb, String capacity, String type, double minprice)
	{
		super(customerID,propertyName, address, suburb, capacity, type);
		this.minprice = minprice;
	}


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
			setPropertyStatus("Payment Awaited");
		}
		else {
			formalOffer();
		}

		return true;
	}

	public void DownPayment()
	{

	}

	public void FinalizeProperty()
	{

	}

//	public void SetAgent(SalesConsultant Emp)
//	{
//		super.Emp = Emp;
//		super.IsAssign = true;
//	}

	public void AddInspections()
	{

	}

//	public String ShowInspections()
//	{
//
//	}

}

