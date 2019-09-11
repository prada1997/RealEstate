
public class PropertyManager extends Employee
{

	Rental[] RProperty;
	
	public PropertyManager(String ename, String eid, String emptype, String designation, 
			String address, long mobno, String email) 
	{
		super(ename, eid, emptype, designation, address, mobno, email);
	
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
