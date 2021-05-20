import java.util.HashMap;
import java.util.Scanner;

public class SandERealEstate {

	private static Scanner input = new Scanner (System.in);

	public static void main(String[] args) throws Exception {
	    	new Record("start");
	    	registerUser();
	}

	public static void registerUser() throws Exception {
		int menuInput;

		do {
			System.out.println("\nS&E Real Estate \nMenu Options \n"
					+ "1: Add Customer \n"
					+ "2: Add Employee\n"
					+ "3: To Switch Employee User\n"
					+ "4: To Switch Customer User \n"
					+ "5: Exit\n"
                    + "Enter your Choice: ");
			menuInput = input.nextInt();

			if (menuInput == 1) {


					Customer obj = addCustomer();
					if (obj == null){
                        System.out.println("Try again.");
                    }
					System.out.println("You have been added in the System.");
					customerOperations(obj);

			}
			else if (menuInput == 2) {
						Employee obj = addEmployee();
                        if (obj == null){
                            System.out.println("Try again.");
                        }
						System.out.println("You have been added in the System.");
						employeeOperations(obj);

				}
			else if (menuInput == 3) {
                HashMap<String, Employee> list = new Record().getEmployeeRecord();

                for(String key : list.keySet()){
                    System.out.println("Employee Id: " + list.get(key).getEmployeeID() +
                            "\nEmployee Name: " + list.get(key).getEmployeeName() +
                            "\nEmployee Type: "+ list.get(key).getEmployeeType() + "\n");
                }

                System.out.println("Enter Employee Id to switch user");
                String input = new Scanner(System.in).next().toLowerCase();
                employeeOperations(new Record().getEmployeeRecord().get(input));

            }


			else if (menuInput == 4){
				HashMap<String, Customer> list = new Record().getCustomerRecord();

				for(String key : list.keySet()){
					System.out.println("Customer Id: " + list.get(key).getCustomerId() +
                                        "\nCustomer Name: " + list.get(key).getCustomerName());
					    if(list.get(key).toString().substring(0,5).equals("Owner")){
					        System.out.println("Customer Type: "+ ((Owner)list.get(key)).getOwnerType() + "\n");
                        }
					    else
                            System.out.println("Customer Type: "+ ((Client)list.get(key)).getClientType() + "\n");
				}

				System.out.println("Enter Customer Id to switch user");
				String input = new Scanner(System.in).next().toLowerCase();
				customerOperations(new Record().getCustomerRecord().get(input));

			}

            else if (menuInput == 5)
            {
                programTermination();
                input.close();
            }
			else if (menuInput > 3) {
					System.out.println("Enter Correct Choice.");
				}

			}while (menuInput > 3);

		}


	public static void customerOperations(Customer obj) throws Exception {

		int menuInput;

		do{
			System.out.println("\n S&E Real Estate \n Menu Options \n"
					+ "1: Add Property. \n"
					+ "2: Accept or Reject Property Application. \n"
					+ "3: Add Application Property. \n"
					+ "4: View Application Status for Property. \n" //edit
					+ "5: BACK\n"
					+ "6. Exit \n"
					+ "Enter your Choice: ");
			menuInput = input.nextInt();

			if(menuInput == 1) {

				if(addProperty(obj)) {
					System.out.println("Property has been added.");
				}
			}

			else if(menuInput == 2) {
				String returnMessage = acceptRejectPropertyApplication(obj);
				if (returnMessage.equals("completed")) {
					System.out.println("Completed Back to Menu");
				}
				else if(returnMessage.equals("wrongUser")) {
					System.out.println("Wrong user, cant access this feature.");
				}
				else if(returnMessage.equals("back")){
					customerOperations(obj);
				}
			}

        	else if(menuInput == 3) {

				if(addApplication(obj)) {
					System.out.println("Application has been added.");
				}
        	}

			else if(menuInput == 4){
				if(obj.getCustomerType().equals("buyer") ||
						obj.getCustomerType().equals("tenant") ) {

					((Client) obj).applicationStatus();
				}
				else
					System.out.println("you don't have access to this feature.");
			}

			else if(menuInput == 5){
				registerUser();
			}

			else if(menuInput == 6) {
				programTermination();
				input.close();
			}

			else if(menuInput > 6) {
				System.out.println("Enter Correct Choice.");
			}

		} while(menuInput > 6);
	}


	public static Customer addCustomer() throws Exception {

			System.out.println("Enter your Name:");
			String customerName = input.next();

			System.out.println("Enter your Email ID:");
			String emailId = input.next();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

			if (emailId.matches(regex)) {
				System.out.println("Enter your Customer Type, \n"
						+ "For Example: landlord, vendor, tenant, buyer");
				String customerType = input.next();

				if (customerType.equals("landlord") || customerType.equals("vendor")) {
					Owner obj;
					new Record(obj = new Owner(customerName, emailId, customerType));
					return obj;

				}
				else if (customerType.equals("buyer") || customerType.equals("tenant")) {
					Client obj;
					new Record(obj = new Client(customerName, emailId, customerType));
					return obj;

				}
				else {
					System.out.println("Enter Correct Customer Type: \n"
							+ "For Example: landlord, vendor, tenant, buyer");
				}
			}
			//else
				//throw new EmailValidationException("Wrong email ID address.");
			return null;

	}


	public static boolean addProperty(Customer obj) {
				
		if(obj.getCustomerType().equals("landlord") ||
				obj.getCustomerType().equals("vendor") ) {

			((Owner) obj).addProperty();
		}
				
		else {
			System.out.println("You cant add property, you are not vendor or landlord.");
			return false;
		}
		
		return true;
	}


	public static boolean addApplication(Customer obj) throws Exception {

		if(obj.getCustomerType().equals("buyer") ||
				obj.getCustomerType().equals("tenant") ) {

			if(!((Client) obj).addApplication()) {
				System.out.println("Application not added.");
				customerOperations(obj);
			}
		}

		else {
			//throw new InvalidUser("Wrong user, cant add application");
			System.out.println("You cant add Application, you are not buyer or tenant.");
			//return false;
		}

		return true;
	}


	public static String acceptRejectPropertyApplication(Customer obj){
		if(obj.getCustomerType().equals("landlord") ||
				obj.getCustomerType().equals("vendor") ) {

			return((Owner) obj).acceptOrRejectOffer();
		}
		return "wrongUser";
	}


	public static void employeeOperations(Employee obj) throws Exception {

		int menuInput;

		do{
			System.out.println("\n S&E Real Estate \n Menu Options \n"
					+ "1: Initiate PayRoll \n"
					+ "2: assign Employee \n"

					+ "4: Check Payroll \n"
					+ "5: Conduct Inspection \n"
					+ "6: BACK\n "
					+ "7. Exit \n"
					+ "Enter your Choice: ");
			menuInput = input.nextInt();

			if(menuInput == 1) {
				if(obj.getDesignation().equals("branch admin")){
					((BranchAdmin)obj).initiatePayRoll();
				}
				else
					System.out.println("you dont have access to this feature.");
			}

			else if(menuInput == 2){
				if(((BranchManager)obj).assignEmployee()){
					System.out.println("Employee Assigned");
				}
				else
					System.out.println("You are in the main menu now.  ");
			}

			else if(menuInput == 3) {
				//salesConsultantOperations(obj);
			}

			else if(menuInput == 4) {
				checkPayroll();
			}

			else if(menuInput == 5) {
				startInspection(obj);
			}

			else if(menuInput == 6) {
				registerUser();
			}

			else if(menuInput == 7) {
				programTermination();
				input.close();
			}

			else if(menuInput > 7) {
				System.out.println("Enter Correct Choice.");
			}

		} while(menuInput > 7);
	}

	private static void checkPayroll() {HashMap<String, Employee> list = new Record().getEmployeeRecord();
		for (String key : list.keySet() ){
			System.out.println(list.get(key).getDetails());
			System.out.println("\n");
		}
	}

	private static void startInspection(Employee obj) {
		if (obj.getEmployeeType().equals("property manager")){
			((PropertyManager)obj).conductInspection();
		}
		else if(obj.getEmployeeType().equals("sales consultant")){
			((SalesConsultant)obj).conductInspection();
		}
		else
			System.out.println("no property Assigned");
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
		}

		return null;
	}


	public static void programTermination(){
		System.out.println("$$$ Program Terminated $$$");
		new Record("terminate");
		System.exit(0);
	}


//    public static void recordFetch(){
//        try {
//
//            System.out.println(new Record().getCustomerRecord().entrySet());
//            System.out.println(new Record().getPropertyRecord().entrySet());
//			//System.out.println(new Record().getPropertyRecord().get("firstProperty").getApplication().size());
////			System.out.println(new Record().getPropertyRecord().get("first").toString().substring(0, 15));
//            System.out.println(new Record().getEmployeeRecord().entrySet());
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
