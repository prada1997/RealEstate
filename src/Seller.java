import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Seller extends Customer implements Serializable
{
	private HashMap<String, Property> property = new HashMap<String, Property>();
	
	protected Seller(String customerName,String emailID,String customerType) throws IOException {
		super(customerName, emailID, customerType);
	}
	
	public void addProperty() 
	{	
		//edit property
		Property p;
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("Enter the name of the Property");
//		String propertyName = scan.next();

		System.out.println("Enter the address : ");
		String add = scan.next();

		System.out.println("Enter the suburb : ");
		String sub = scan.next();

		System.out.println("Enter the capacity : ");
		String cap = scan.next();

		System.out.println("Enter the type : ");
		String type = scan.next();

		System.out.println("Please specify the property category(For Sales Or Rental) : ");
		String category = scan.next();
		
		if (category.equalsIgnoreCase("sales")) {
			System.out.println("Enter the minimum price : ");
			double min = scan.nextDouble();
			new Sales(add,sub,cap,type,min);
			         
			         //property.put(propertyName, p);
				}
		else if (category.equalsIgnoreCase("rental"))
		{
			System.out.println("Enter the management fee : ");
	        double mfee = scan.nextDouble();
	        System.out.println("Enter the Rental Amount : ");
	        double ramount = scan.nextDouble();
	        System.out.println("Enter the stay duration : ");
	        double dur = scan.nextDouble();
	        
	        p = new Rental( add,sub,cap,type,mfee,ramount,dur);
	        //property.put(propertyName, p);
		}
		else {
			System.out.println("Please enter the correct category for the property." +
					" \nFor example: Sales or Rental ");
			addProperty();
		}
	}


	public Property searchproperty (String propertyName) {
		
		if(property.containsKey(propertyName)) {
			return property.get(propertyName);
			
		}
		
		return null;
	}

	
	public void showApplication() {
		for (String key : property.keySet()) {
			
			property.get(key).showApplication();
		}
	}
}

	

		
		
		
		
		
		 
	
	

