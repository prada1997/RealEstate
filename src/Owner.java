import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Owner extends Customer implements Serializable{
	private String ownerType;
	private HashMap<String, Property> property = new HashMap<String, Property>();
	
	protected Owner(String customerName, String emailID, String customerType) throws IOException {
		super(customerName, emailID,customerType);
		this.ownerType = customerType;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void addProperty()
	{	
		//edit property
		Property p;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the name of the Property");
		String propertyName = scan.next();

		System.out.println("Enter the address : ");
		String add = scan.next();

		System.out.println("Enter the suburb : ");
		String sub = scan.next();

		System.out.println("Enter the capacity : ");
		String cap = scan.next();
		
		if (ownerType.equalsIgnoreCase("vendor")) {
			System.out.println("Enter the minimum price : ");
			double min = scan.nextDouble();

			PropertyForSale object = new PropertyForSale(propertyName,add,sub,cap,min);
			new Record(object);
			property.put(propertyName, object);
		}

		else if (ownerType.equalsIgnoreCase("landlord"))
		{
			System.out.println("Enter the management fee : ");
	        double mfee = scan.nextDouble();
	        System.out.println("Enter the Rental Amount : ");
	        double ramount = scan.nextDouble();
	        System.out.println("Enter the stay duration : ");
	        double dur = scan.nextDouble();

	        PropertyForRent object;
			new Record(object = new PropertyForRent(propertyName,add,sub,cap,mfee,ramount,dur));
	        property.put(propertyName, object );
		}
	}


	public String acceptOrRejectOffer(){

		if(ownerType.equals("landlord")){
			System.out.println("Choose Property to Accept Application.");
			for(String key : property.keySet()){
				System.out.print("Property name: "+property.get(key).getPropertyName() + "\nSatus: " + property.get(key).getPropertyStatus());
				System.out.print("\t");
				System.out.print(" \nNumber of Applications: " +property.get(key).getApplication().size());
				System.out.print("\n");
			}
			System.out.println("Enter property name to view applications. \nType BACK for previous menu");
			String input = new Scanner(System.in).next();
			if(input.toLowerCase().equals("back")){
				return "back";
			}
			return ((PropertyForRent)property.get(input)).applicationOffer();

		}
		else if (ownerType.equals("vendor")){

			System.out.println("Choose Property to Accept Application.");
			for(String key : property.keySet()){
				System.out.print("Property name: "+property.get(key).getPropertyName() + "\nSatus: " + property.get(key).getPropertyStatus());
				System.out.print("\t");
				System.out.print(" \nNumber of Applications: " +property.get(key).getApplication().size());
				System.out.print("\n");
			}
			System.out.println("Enter property name to view applications. \nType BACK for previous menu");
			String input = new Scanner(System.in).next();
			if(input.toLowerCase().equals("back")){
				return "back";
			}
			return  ((PropertyForSale)property.get(input)).buyingOffer();

		}
		return "back";
	}

	public String showDetails()
	{
		String details = "customerName =" + getCustomerName() +
				"\nemailID =" + getEmailID() +
				"\ncustomerType =" + ownerType +
				"\nuniqueID =" + getCustomerId();

		return details;
	}
}

	

		
		
		
		
		
		 
	
	

