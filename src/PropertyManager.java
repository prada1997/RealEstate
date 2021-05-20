import java.io.Serializable;
import java.util.Scanner;

public class PropertyManager extends Employee implements Serializable
{
	private PropertyForRent propertyAssigned;
	
	public PropertyManager(String employeeName, String email, String designation, String emptype)
	{
		super(employeeName, email, designation, emptype);
	
	}

	public void setPropertyAssigned(PropertyForRent property) {
		this.propertyAssigned = property;
	}

	public boolean conductInspection()
	{
		String time;

		if(propertyAssigned == null){
			return false;
		}
		propertyAssigned.displayInspection();
		System.out.println("Enter the Inspection time choice:");
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();

		switch(i){
			case 1:
				time = "10:45 - 11:00";
				propertyAssigned.setInspection(time);
				break;
			case 2:
				time = "11:45 - 12:00";
				propertyAssigned.setInspection(time);
				break;
			case 3:
				time = "12:45 - 13:00";
				propertyAssigned.setInspection(time);
				break;
			case 4:
				time = "13:45 - 14:00";
				propertyAssigned.setInspection(time);
				break;
			case 5:
				time = "14:45 - 15:00";
				propertyAssigned.setInspection(time);
				break;
		}
	return true;
	}
}
