import java.io.IOException;
import java.util.Scanner;

public class SandERealEstate {

	private static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
	    try {

	    	new Record("start");
	    	recordFetch();
	    	typeOfUser(2);
        }
	    catch (Exception e){
	        e.printStackTrace();
        }
	}


//    public static int userOperations() throws IOException, ClassNotFoundException, EmailValidationException, InvalidUser, UserNotExist {
//        int menuInput = 0;
//
//        do{
//            System.out.println("\nS&E Real Estate \nMenu Options \n"
//                    + "1: Login \n"
//                    + "2: Sign Up\n"
//                    + "3. Exit \n"
//                    + "Enter your Choice: ");
//            menuInput = input.nextInt();
//
//            if(menuInput == 1)
//                typeOfUser(1);
//
//            else if(menuInput == 2)
//                typeOfUser(2);
//
//        	else if(menuInput == 3) {
//                System.out.println("$$$ Program Terminated $$$");
//                new Record("terminate");
//                numberOfRun++;
//                System.exit(0);
//                input.close();
//            }
//
//            else if(menuInput > 3) {
//                System.out.println("Enter Correct Choice.");
//                userOperations();
//            }
//
//        } while(true);
//    }


	public static void typeOfUser(int userOperation) throws IOException, ClassNotFoundException, EmailValidationException, InvalidUser, UserNotExist {
		int menuInput;

		do {
			System.out.println("\nS&E Real Estate \nMenu Options \n"
					+ "1: Add Customer \n"
					+ "2: Add Employee\n"
					+ "3. Exit \n"
					+ "Enter your Choice: ");
			menuInput = input.nextInt();

			if (menuInput == 1) {

//				if(userOperation == 1) {
//					System.out.println("Enter your Name:");
//					String customerName = input.next();
//
//					System.out.println("Enter your Email ID:");
//					String emailId = input.next();
//
//					Customer obj = checkCustomerUser(customerName,emailId);
//					if(obj != null) {
//						System.out.println("Hi NAME, you have been logged in. " + "");
//						customerOperations(obj);
//					}
//					else
//						System.out.println("You are not a existing User.");
//
//				}

				if (userOperation == 2) {
					Customer obj = addCustomer();
					System.out.println("You have been added in the System.");
					customerOperations(obj);

				}
			}
			else if (menuInput == 2) {

//				if (userOperation == 1) {
//					Employee obj = checkEmployeeUser();
//					if(obj != null){
//						System.out.println("Hi NAME, you have been logged in. " + "");
//						employeeOperations(obj);
//					}
//
//					else
//						System.out.println("You are not a existing User.");
//
//				}

					if (userOperation == 2) {
						Employee obj = addEmployee();
						System.out.println("You have been added in the System.");
						employeeOperations(obj);
					}

				}
			else if (menuInput == 3) {
					programTermination();
					input.close();
				}
			else if (menuInput > 3) {
					System.out.println("Enter Correct Choice.");
					typeOfUser(userOperation);
				}

			}while (true);

		}


//	public static Customer checkCustomerUser(String emailId, String customerName) throws UserNotExist {
//		try {
//			Customer obj = new Record().getCustomerRecord().get(emailId);
//			if (obj.getEmailID().equals(emailId) || obj.getCustomerName().equals(customerName)) {
//				return obj;
//			}
//		}
//		catch (Exception e){
//			throw new UserNotExist("User does not exist.");
//		}
//		return null;
//	}


//	public static Employee checkEmployeeUser() {
//		System.out.println("Enter your Name:");
//		String customerName = input.next();
//
//		System.out.println("Enter your Email ID:");
//		String emailId = input.next();
//
//		Employee obj = new Record().getEmployeeRecord().get(emailId);
//		if (obj.getEmail().equals(emailId) || obj.getEmployeeName().equals(customerName)) {
//			return obj;
//		}
//
//		return null;
//	}


	public static void customerOperations(Customer obj) throws InvalidUser {

		int menuInput;

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
				programTermination();
				input.close();
			}

			else if(menuInput > 4) {
				System.out.println("Enter Correct Choice.");
				customerOperations(obj);
			}

		} while(true);
	}


	public static Customer addCustomer() throws IOException, EmailValidationException{

			System.out.println("Enter your Name:");
			String customerName = input.next();

			System.out.println("Enter your Email ID:");
			String emailId = input.next();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

			if (emailId.matches(regex)) {
				System.out.println("Enter your Customer Type, \n"
						+ "For Example: landlord, vendor, renter, buyer");
				String customerType = input.next();

				if (customerType.equals("landlord") || customerType.equals("vendor")) {
					Seller obj;
					new Record(obj = new Seller(customerName, emailId, customerType));
					return obj;

				}
				else if (customerType.equals("buyer") || customerType.equals("renter")) {
					Buyer obj;
					new Record(obj = new Buyer(customerName, emailId, customerType));
					return obj;

				}
				else {
					System.out.println("Enter Correct Customer Type: \n"
							+ "For Example: landlord, vendor, renter, buyer");
					addCustomer();
				}
			}
			else
				throw new EmailValidationException("Wrong email ID address.");
			return null;

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


	public static boolean addApplication(Customer obj) throws InvalidUser {

		if(obj.getCustomerType().equals("buyer") ||
				obj.getCustomerType().equals("renter") ) {

		    for(String key : new Record().getCustomerRecord().keySet() ){
                if(obj.getCustomerType().equals("vendor") ||
                        obj.getCustomerType().equals("landlord") ) {

                }
            }

//			System.out.println("Enter property name for application:");
//			String propertyName = input.next();
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

			new Application(income, pastOccupation, currentOccupation, pastRental, currentRental);
		}

		else {
			throw new InvalidUser("Wrong user, cant add application");
			//System.out.println("You cant add Application, you are not buyer or renter.");
			//return false;
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
				programTermination();
				input.close();
			}

			else if(menuInput > 5) {
				System.out.println("Enter Correct Choice.");
				employeeOperations(obj);
			}

		} while(true);
	}


	public static Employee addEmployee() {
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
			SalesConsultant obj;
			new Record(obj = new SalesConsultant(employeeName, emailId, designation, employeeType));
			return obj;
		}

		else if (designation.toUpperCase().equals("PROPERTY MANAGER")){
			PropertyManager obj;
			new Record(obj = new PropertyManager(employeeName, emailId, designation, employeeType));
			return obj;
		}

		else if (designation.toUpperCase().equals("BRANCH ADMIN")){
			BranchAdmin obj;
			new Record(obj = new BranchAdmin(employeeName, emailId, designation, employeeType));
			return obj;
		}

		else if (designation.toUpperCase().equals("BRANCH MANAGER")){
			BranchManager obj;
			new Record(obj = new BranchManager(employeeName, emailId, designation, employeeType));
			return obj;
		}

		else {
				System.out.println("Enter Correct Designation");
				addEmployee();
		}

		return null;
	}


	public static void programTermination(){
		System.out.println("$$$ Program Terminated $$$");
		new Record("terminate");
		System.exit(0);
	}


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
