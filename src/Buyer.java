import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Buyer extends Customer implements Serializable {

	private ArrayList<String> interestedSuburbs = new ArrayList<String>();
	private HashMap<Integer, Application> application = new HashMap<Integer, Application>();
	private int enteries = 1;


	protected Buyer(String customerName, String emailID, String customerType) throws IOException {
		super(customerName, emailID, customerType);
	}

	public void addApplication() {
		HashMap<String, Property> list = new Record().getPropertyRecord();
		System.out.println("List of properties:");
		for(String key : list.keySet()){
			System.out.print(list.get(key).getPropertyName());
			System.out.print("\t");
			//display property details
			//System.out.print(list.get(key).getApplication().size());
			System.out.print("\n");
		}

		Scanner input = new Scanner(System.in);
		System.out.println("Enter property name for application:");
		String propertyName = input.next();
		System.out.println("Enter your income: ");
		double income = input.nextDouble();
		System.out.println("Enter your past occupation: ");
		String pastOccupation = input.next();
		System.out.println("Enter your current occupation: ");
		String currentOccupation = input.next();
		System.out.println("Enter your past rental: ");
		double pastRental = input.nextDouble();
		System.out.println("Enter your current rental: ");
		double currentRental = input.nextDouble();
		Application object = new Application(getCustomerId(), propertyName, income,
				pastOccupation, currentOccupation, pastRental, currentRental);
		application.put(enteries,object);
		new Record().getPropertyRecord().get(propertyName).addingApplication(object);
	}
	public void addInterest() {
		Scanner scan = new Scanner(System.in);
		String ans = null;
		do {
			System.out.println("Enter the interested Suburb: ");
			String sub = scan.nextLine();
			this.interestedSuburbs.add(sub);
			System.out.println("Do you want to enter more Suburb (Yes/No)");
			ans = scan.nextLine();
		}
		while (ans.equalsIgnoreCase("Yes"));
	}

	public void applicationStatus(){
		for (int key : application.keySet()){
			System.out.print(key + " Application");
			System.out.println("Property name: " + application.get(key).propertyName);
			System.out.println("Status" + application.get(key).getApplicationStatus());
		}
	}

}
