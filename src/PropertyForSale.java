import java.io.Serializable;
import java.util.Scanner;

public class PropertyForSale extends Property implements Serializable {
	private double minprice;

	public PropertyForSale(String propertyName, String address, String suburb, String capacity, double minprice) {
		super(propertyName, address, suburb, capacity);
		this.minprice = minprice;
	}


	public String buyingOffer() {
		String decision = null;
		int num = 1;
		System.out.println("Select Application for the property. \nType number");
		for (int i : getApplication().keySet()) {
			System.out.print("Application " + num + ":");
			System.out.print(getApplication().get(i).tenantApplicationDisplay());
			System.out.println("\n");
			num++;
		}

		System.out.print("To select application enter application ID:");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
			if (getApplication().containsKey(choice)) {
				System.out.println("Please enter the Decision i.e. Accept or Reject\n Give new offer to Buyer: ");
				decision = new Scanner(System.in).next();
				getApplication().get(choice).setApplicationStatus(decision);
				setPropertyStatus("Payment Awaited");
			}
		return "completed";
	}
}
