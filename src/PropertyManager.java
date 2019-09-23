import java.io.Serializable;

public class PropertyManager extends Employee implements Serializable
{

	Rental[] RProperty;
	
	public PropertyManager(String employeeName, String email, String designation, String emptype)
	{
		super(employeeName, email, designation, emptype);
	
	}

	
	public void ConductInspection() 
	{
		
	}
	
	public void AssignProperty(Rental property) 
	{
		for(int i=0; i<RProperty.length; i++) 
		{
			if(RProperty[i] == null) 
			{
				RProperty[i] = property;
				break;
			}
		}
	}
	
	
	
	
	
}
