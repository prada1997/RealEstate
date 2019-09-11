
public class SalesConsultant extends Employee 
{

	private double Bonus;
	private Sales[] SProperty;
	
	public SalesConsultant(String ename, String id, String type, String designation, String addr
			,long mobno,String emailid, float nofohours) 
	{
		super(ename, id, type, designation, addr, mobno, emailid, nofohours);
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
