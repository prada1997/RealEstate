import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class SandERealEstate implements Serializable {
	
	public static Scanner input = new Scanner (System.in);


	public static void main(String[] args) throws IOException {
		menu();
	}

	
	public static void menu() throws IOException {
		
		int menuInput = 0;
		
		do{
        	System.out.println("\n S&E Real Estate \n Menu Options \n"
        						+ "1: Add Customer \n"
        						+ "2: Show all Customer \n"
        						+ "3: Add Employee \n"
        						+ "4: Show all Employee \n"
        						+ "5: Add Property \n"
        						+ "6: Add Application \n"
        						
        						+ "8. Exit \n"
        						+ "Enter your Choice: ");
        	menuInput = input.nextInt();	
        	
        	if(menuInput == 1) {	
        		        		        		
        		if(addCustomer())
        			System.out.println("Customer has been added.");
        	}
        	        	
        	/*else if(menuInput == 2) {
				for (String id: customerRecord.keySet()) {
					//changing method to string
					System.out.println(customerRecord.get(id).ShowDetails());
					System.out.println("\n");
				}
        	}
        	        	
        	else if(menuInput == 3) {
        		addEmployee();
        		
        	}
        	
        	else if(menuInput == 4) {	
        		showEmployee();
        	}
        	        	
        	else if(menuInput == 5) {
        		if(addProperty()) {
        			System.out.println("Property have been added.");
        		}
   
        	}
        	        	
        	else if(menuInput == 6) {
        		if(addApplication()) {
					System.out.println("Application have been added.");
				}
        	} 
        	               	
        	else if(menuInput == 7) {
        		displayApplication();
        	}*/
        	
        	else if(menuInput == 8) {
        		System.out.println("$$$ Program Terminated $$$");
        		System.exit(0);
        	}
        	
        	else if(menuInput > 8) {
        		System.out.println("Enter Correct Choice.");
        		menu();
        	}
        	
        } while(menuInput != 8);
        input.close();
        
	}
	
	
	public static boolean addCustomer() throws IOException {
		
		System.out.println("Enter your Name:");
		String customerName = input.next();
	
		System.out.println("Enter your Email ID:");
		String emailId = input.next();
		
		System.out.println("Enter your Customer Type, \n"
							+ "For Example: landlord, vendor, renter, buyer");
		String customerType = input.next();
		
		if(customerType.equals("landlord") || customerType.equals("vendor"))
			new Seller(customerName, emailId, customerType);
		
		else if(customerType.equals("buyer") || customerType.equals("renter"))
			new Buyer(customerName, emailId, customerType);

		return true;
	}
	

	
	/*public static boolean addProperty() {
		System.out.println("Enter your customer Name:");
		String customerName = input.next();
		Seller obj;
		for (String id: customerRecord.keySet()) {
			
			if(customerRecord.get(id).getCustomerName().equals(customerName)) {
				
				if(customerRecord.get(id).getCustomerType().equals("landlord") ||
						customerRecord.get(id).getCustomerType().equals("vendor") ) {
				
					obj = (Seller) customerRecord.get(id);
				obj.addProperty();
				break;
				}
				
				else {
					System.out.println("You cant add property, you are not vendor or landlord");
					return false;
				}
			}
		}
		
		//obj.addProperty();
		
		return true;
	}


	public static boolean addApplication() {
		System.out.println("Enter your customer Name:");
		String customerName = input.next();
		Buyer obj;
		String propertyName ="";
		for (String id: customerRecord.keySet()) {
			
			if(customerRecord.get(id).getCustomerName().equals(customerName)) {
				
				if(customerRecord.get(id).getCustomerType().equals("buyer") ||
						customerRecord.get(id).getCustomerType().equals("renter") ) {
				
					obj = (Buyer) customerRecord.get(id);
					propertyName = obj.addApplication();
					Property o;
					Seller object;
					for (String key: customerRecord.keySet()) {
						
							if(customerRecord.get(key).getCustomerType().equals("vendor") ||
									customerRecord.get(key).getCustomerType().equals("landlord") ) {
							
								object = (Seller) customerRecord.get(key);
								if(object.searchproperty(propertyName).addingAplication(obj.getApplications().get(propertyName)));
									break;
							}
							
//							else {
//								System.out.println("You cant add property, you are not vendor or landlord");
//								return false;
//							}
						}
				break;
				}
				
				else {
					System.out.println("You cant add property, you are not buyer or renter");
					return false;
				}
			}
		}
//		Property o;
//		Seller object;
//		for (String id: customerRecord.keySet()) {
//			
//				if(customerRecord.get(id).getCustomerType().equals("vendor") ||
//						customerRecord.get(id).getCustomerType().equals("landlord") ) {
//				
//					object = (Seller) customerRecord.get(id);
//					if(object.searchproperty(propertyName).addingAplication((Buyer) obj.getApplications().get(propertyName)));
//				break;
//				}
//				
//				else {
//					System.out.println("You cant add property, you are not vendor or landlord");
//					return false;
//				}
//			}
		
		return true;
	}
	
	
	public static void displayApplication() {
		System.out.println("Enter your customer Name:");
		String customerName = input.next();
		Seller obj;
		for (String id: customerRecord.keySet()) {
			
			if(customerRecord.get(id).getCustomerName().equals(customerName)) {
				
				if(customerRecord.get(id).getCustomerType().equals("landlord") ||
						customerRecord.get(id).getCustomerType().equals("vendor") ) {
					obj = (Seller) customerRecord.get(id);
					obj.showApplication();
				}
			}
		}
	}


	public static void addEmployee() {
	System.out.println("Enter the employee name");
	String name=input.next();
	
	System.out.println("Enter the employee id");
	String id=input.next();
	
	System.out.println("Enter the employee type(Fulltime/Part time)");
	String type=input.next();
	type = type + input.nextLine();
	
	
	System.out.println("Enter the employee Designation(ONLY SALES CONSULTANT HAS THE OPTION TO BE FULL TIME OR PART TIME");
	String desig=input.next();
	desig = desig + input.nextLine();
	
	System.out.println("Enter the employee address");
	String addr=input.next();
	
	System.out.println("Enter the employee Mobilenumber");
	long mobno=input.nextInt();
	
	System.out.println("Enter the employee email");
	String emailid=input.next();
	
	
	if(type.toUpperCase().equals("PART TIME"))
	{
		System.out.println("ONLY SALES CONSULTANT CAN BE A PART TIME  SO ENTER NO OF HOURS WORKED BY SALES CONSULTANT");
		
		
		System.out.println("Enter the hrs worked");
		float noofhours=input.nextFloat();
		
			SalesConsultant s= new SalesConsultant(name,id,type,"Salesconsultant",addr,mobno,emailid,noofhours);
			employeeRecord.put(name, s);
			System.out.println("Employee has been added.");
			
	}
	
	else if(type.toUpperCase().equals("FULL TIME"))
	{
		if(desig.toUpperCase().equals("PROPERTY MANAGER"))
		{
			PropertyManager p=new PropertyManager(name,id,type,"Property Manager",addr,mobno,emailid);
			employeeRecord.put(name, p);
			System.out.println("Employee has been added.");
		
		}	
		
		
		else if (desig.toUpperCase().equals("SALES CONSULTANT"))
		{
			SalesConsultant s= new SalesConsultant(name,id,type,"Sales consultant",addr,mobno,emailid,63);
			// If Sales consultant is full time then set noofhrs=63 full timen 
			employeeRecord.put(name, s);
			System.out.println("Employee has been added.");
			
		}
	
		else
		{
			BranchManager m= new BranchManager(name,id,type,"Branch manager",mobno,addr,emailid);
			employeeRecord.put(name, m);
		}	
		
	}
	
	else
		{
			System.out.println("WRONG TYPE ENTERED");	
		}
	
	}
	
	
	public static void showEmployee() {
		System.out.println(employeeRecord.keySet());
		for (String id : employeeRecord.keySet() ) {
			
			System.out.println(employeeRecord.get(id).getDetails());
			//System.out.println("test");
		}
	}*/
	
//	public static boolean addEmployee() {
//		
//		System.out.println("Enter your Name:");
//		String customerName = input.next();
//	
//		System.out.println("Enter your Email ID:");
//		String emailId = input.next();
//		
//		System.out.println("Enter your Customer Type, \n"
//							+ "For Example: Landlord, Vendor, Renter, Buyer");
//		String customerType = input.next();
//		
//		Customer obj = new Customer(customerName, emailId, customerType);
//		customerRecord.put(obj.getUniqueID(), obj);
//		
//		return true;
//	}
//	
}
