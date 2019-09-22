import java.io.IOException;
import java.util.Scanner;

public class SandERealEstate {

	private static Scanner input = new Scanner (System.in);
	//if the program running for first time and may be dir not present
	private static int numberOfRun = 0;

	public static void main(String[] args) {
	    try {
	    	if(numberOfRun == 0)
	    		new Record("start");
	    	recordFetch();
	    	userOperations();
        }
	    catch (Exception e){
	        e.printStackTrace();
        }
	}


    public static int userOperations() throws IOException, ClassNotFoundException {
        int menuInput = 0;

        do{
            System.out.println("\nS&E Real Estate \nMenu Options \n"
                    + "1: Login \n"
                    + "2: Sign Up\n"
                    + "3. Exit \n"
                    + "Enter your Choice: ");
            menuInput = input.nextInt();

            if(menuInput == 1)
                typeOfUser(1);

            else if(menuInput == 2)
                typeOfUser(2);

        	else if(menuInput == 3) {
                System.out.println("$$$ Program Terminated $$$");
                new Record("terminate");
                numberOfRun++;
                System.exit(0);
                input.close();
            }

            else if(menuInput > 3) {
                System.out.println("Enter Correct Choice.");
                userOperations();
            }

        } while(true);
    }


	public static void typeOfUser(int userOperation) throws IOException, ClassNotFoundException {
		int menuInput = 0;

		do{
			System.out.println("\nS&E Real Estate \nMenu Options \n"
					+ "1: Customer \n"
					+ "2: Employee\n"
					+ "3. Exit \n"
					+ "Enter your Choice: ");
			menuInput = input.nextInt();

			if(menuInput == 1) {

				if(userOperation == 1) {
					Customer obj = checkCustomerUser();
					if(obj != null) {
						System.out.println("Hi NAME, you have been logged in. " + "");
						customerOperations(obj);
					}
					else
						System.out.println("You are not a existing User.");

				}

				else if(userOperation == 2) {
					if(addCustomer())
						System.out.println("You have been added in the System.");
					userOperations();
				}
			}

			else if(menuInput == 2) {

				if (userOperation == 1) {
					Employee obj = checkEmployeeUser();
					if(obj != null){
						System.out.println("Hi NAME, you have been logged in. " + "");
						employeeOperations(obj);
					}

					else
						System.out.println("You are not a existing User.");

				}

				else if(userOperation == 2) {
					if(addEmployee())
						System.out.println("You have been added in the System.");
					userOperations();
				}

			}

			else if(menuInput == 3) {
				System.out.println("$$$ Program Terminated $$$");
				new Record("terminate");
				numberOfRun++;
				System.exit(0);
				input.close();
			}

			else if(menuInput > 3) {
				System.out.println("Enter Correct Choice.");
				typeOfUser(userOperation);
			}

		} while(true);
	}


	public static Customer checkCustomerUser(){
		System.out.println("Enter your Name:");
		String customerName = input.next();

		System.out.println("Enter your Email ID:");
		String emailId = input.next();

		Customer obj = new Record().getCustomerRecord().get(emailId);
		if(obj.getEmailID().equals(emailId) || obj.getCustomerName().equals(customerName)) {
			return obj;
		}

		return null;
	}


	public static Employee checkEmployeeUser() {
		System.out.println("Enter your Name:");
		String customerName = input.next();

		System.out.println("Enter your Email ID:");
		String emailId = input.next();

		Employee obj = new Record().getEmployeeRecord().get(emailId);
		if (obj.getEmail().equals(emailId) || obj.getEmployeeName().equals(customerName)) {
			return obj;
		}

		return null;
	}


	public static void customerOperations(Customer obj) {

		int menuInput = 0;

		do{
			System.out.println("\n S&E Real Estate \n Menu Options \n"
					+ "1: Add Property \n"
					+ "2: Edit Property \n"
					+ "3: Add Application \n"
					+ "4. Exit \n"
					+ "Enter your Choice: ");
			menuInput = input.nextInt();

			if(menuInput == 1) {

				if(addProperty(obj)) {
					System.out.println("Property has been added.");
				}
			}

			else if(menuInput == 2){

				//editProperty();
			}

        	else if(menuInput == 3) {

				if(addApplication(obj)) {
					System.out.println("Application has been added.");
				}
        	}

			else if(menuInput == 4) {
				System.out.println("$$$ Program Terminated $$$");
				new Record("terminate");
				numberOfRun++;
				System.exit(0);
				input.close();
			}

			else if(menuInput > 4) {
				System.out.println("Enter Correct Choice.");
				customerOperations(obj);
			}

		} while(true);
	}


	public static boolean addCustomer() throws IOException {
		
		System.out.println("Enter your Name:");
		String customerName = input.next();
	
		System.out.println("Enter your Email ID:");
		String emailId = input.next();
		
		System.out.println("Enter your Customer Type, \n"
							+ "For Example: landlord, vendor, renter, buyer");
		String customerType = input.next();
		
		if(customerType.equals("landlord") || customerType.equals("vendor")) {
			new Record(new Seller(customerName, emailId, customerType));
			return true;
		}
		
		else if(customerType.equals("buyer") || customerType.equals("renter")) {
			new Record(new Buyer(customerName, emailId, customerType));
			return true;
		}

		else{
			System.out.println("Enter Correct Customer Type: \n"
								+ "For Example: landlord, vendor, renter, buyer");
			addCustomer();
		}

		return false;
	}


	public static boolean addProperty(Customer obj) {
				
		if(obj.getCustomerType().equals("landlord") ||
				obj.getCustomerType().equals("vendor") ) {

			Seller object = (Seller) obj;
			object.addProperty();
		}
				
		else {
			System.out.println("You cant add property, you are not vendor or landlord.");
			return false;
		}
		
		return true;
	}


	public static boolean addApplication(Customer obj) {
/*		System.out.println("Enter your customer Name:");
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
		
		return true;*/

		if(obj.getCustomerType().equals("buyer") ||
				obj.getCustomerType().equals("renter") ) {

			Buyer object = (Buyer) obj;
			object.addApplication();
		}

		else {
			System.out.println("You cant add Application, you are not buyer or renter.");
			return false;
		}

		return true;
	}


	public static void employeeOperations(Employee obj) {

		int menuInput;

		do{
			System.out.println("\n S&E Real Estate \n Menu Options \n"
					+ "1: Branch Admin \n"
					+ "2: Branch Manager \n"
					+ "3: Sales Consultant \n"
					+ "4: Property Manager \n"
					+ "5. Exit \n"
					+ "Enter your Choice: ");
			menuInput = input.nextInt();

			if(menuInput == 1) {
				//branchAdminOperations(obj);
			}

			else if(menuInput == 2){
				//branchManagerOperations(obj);
			}

			else if(menuInput == 3) {
				//salesConsultantOperations(obj);
			}

			else if(menuInput == 4) {
				//propertyManagerOperations(obj);
			}

			else if(menuInput == 5) {
				System.out.println("$$$ Program Terminated $$$");
				new Record("terminate");
				numberOfRun++;
				System.exit(0);
				input.close();
			}

			else if(menuInput > 5) {
				System.out.println("Enter Correct Choice.");
				employeeOperations(obj);
			}

		} while(true);
	}

/*
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
*/

	public static Boolean addEmployee() {
		System.out.println("Enter the employee name");
		String employeeName=input.next();

		System.out.println("Enter the employee email");
		String emailId=input.next();

		System.out.println("Enter the employee Designation.");
		String designation =input.next();
		designation = designation + input.nextLine();

		System.out.println("Enter the employee type(Full time/Part time)");
		String employeeType=input.next();
		employeeType = employeeType + input.nextLine();


		if(designation.toUpperCase().equals("SALES CONSULTANT")) {
			new Record(new SalesConsultant(employeeName, emailId, designation, employeeType));
			return true;
		}

		else if (designation.toUpperCase().equals("PROPERTY MANAGER")){
			new Record(new PropertyManager(employeeName, emailId, designation, employeeType));
			return true;
		}

		else if (designation.toUpperCase().equals("BRANCH ADMIN")){
			new Record(new BranchAdmin(employeeName, emailId, designation, employeeType));
			return true;
		}

		else if (designation.toUpperCase().equals("BRANCH MANAGER")){
			new Record(new BranchManager(employeeName, emailId, designation, employeeType));
			return true;
		}

		else {
				System.out.println("Enter Correct Designation");
				addEmployee();
		}

		return false;
	}

	/*
	public static void showEmployee() {
		System.out.println(employeeRecord.keySet());
		for (String id : employeeRecord.keySet() ) {
			
			System.out.println(employeeRecord.get(id).getDetails());
			//System.out.println("test");
		}
	}*/

    public static void recordFetch(){
        try {

            System.out.println(new Record().getCustomerRecord().entrySet());
            //System.out.println(object.getCustomerRecord().entrySet());
            System.out.println(new Record().getEmployeeRecord().entrySet());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
