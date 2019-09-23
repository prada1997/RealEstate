import java.io.Serializable;

public class SalesConsultant extends Employee implements Serializable
{

	private double Bonus;
	private Sales[] SProperty;
	
	public SalesConsultant(String employeeName, String email, String designation, String emptype)
	{
		super(employeeName, email, designation, emptype);
		// TODO Auto-generated constructor stub
	}

	
	public void ConductInspection() 
	{
		
	}
	
	
	public void AssignProperty(Sales property) 
	{
		for(int i=0; i<SProperty.length; i++) 
		{
			if(SProperty[i] == null) 
			{
				SProperty[i] = property;
				break;
			}
		}
	}
	
	
	
	
	
	
}
