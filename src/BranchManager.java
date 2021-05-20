import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class BranchManager extends Employee implements Serializable {

	public BranchManager(String employeeName, String email, String designation, String emptype)
	{
	super(employeeName, email, designation, emptype);
	}
	
	public boolean assignEmployee()
	{
		HashMap<String, Property> list = new Record().getPropertyRecord();
		System.out.println("List of Property. \n");
		for (String key : list.keySet() ){
			System.out.println("Property Name: "+list.get(key).getPropertyName() );
			System.out.println("Employee Assign Status: ");
			if(!list.get(key).isAssign()){
				System.out.print("Not Assigned \n");
			}
			else
				System.out.println("Assigned");
		}

		System.out.println("Enter The property name to be assigned.\n Type back for previous menu");
		String propertyName = new Scanner(System.in).next();
		if(propertyName.equals("back"))
			return false;

		HashMap<String, Employee> employeeList = new Record().getEmployeeRecord();
		System.out.println("List of Employee available. \n");
		for (String key : employeeList.keySet() ) {


			if (list.get(propertyName).toString().substring(0, 15).equals("PropertyForSale")) {
				if (employeeList.get(key).getDesignation().equals("sales consultant")) {

					System.out.println("Employee ID: " + employeeList.get(key).getEmployeeID());
					System.out.println("Employee Assign Status: ");
					if (!employeeList.get(key).isAssign()) {
						System.out.print("Not Assigned \n");
					}
				}


			}

			if (list.get(propertyName).toString().substring(0, 16).equals("PropertyForRent")) {
				if (employeeList.get(key).getDesignation().equals("property manager")) {
					System.out.println("Employee ID: " + employeeList.get(key).getEmployeeID());
					System.out.println("Employee Assign Status: ");
					if (!employeeList.get(key).isAssign()) {
						System.out.print("Not Assigned \n");
					}
				}
			}
		}
		System.out.println("Select the Employee ID to be assigned. \nType back for main Menu.");
		String id = new Scanner(System.in).next();

		//two different lines of assigning.
		if(employeeList.get(id).getDesignation().equals("sales consultant")){
			((SalesConsultant)employeeList.get(id)).setPropertyAssigned((PropertyForSale)list.get(propertyName));
			new Record().getPropertyRecord().get(propertyName).setAssign(true);
			System.out.println("Employee Assigned");
		}
		else if(employeeList.get(id).getDesignation().equals("property manager")){
			((PropertyManager)employeeList.get(id)).setPropertyAssigned((PropertyForRent) list.get(propertyName));
			new Record().getPropertyRecord().get(propertyName).setAssign(true);
			System.out.println("Employee Assigned");
		}
		else
			return false;
		return true;
	}

}


