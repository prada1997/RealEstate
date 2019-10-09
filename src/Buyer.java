import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Buyer extends Customer implements Serializable {

	private ArrayList<String> interestedSuburbs = new ArrayList<String>();
	//private ArrayList<Application> application = new ArrayList<Application>();

	protected Buyer(String customerName, String emailID, String customerType) throws IOException {
		super(customerName, emailID, customerType);
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

}
