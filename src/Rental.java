
public class Rental extends Property
{
	private double  ManagementFee;
	private double RentalAmt;
	private double CDuration;
	
	
	
	public Rental( String address, String suburb, String capacity, String type, double Mfee, double RAmt, double Dur)
	{
		super( address, suburb, capacity, type);
		this.ManagementFee = Mfee;
		this.RentalAmt = RAmt;
		this.CDuration = Dur;
	}

//	public void SetAgent(PropertyManager Emp) 
//	{
//		this.Emp = Emp;
//		IsAssign = true;
//	}
	
	public void AddInspections() 
	{
		
	}
	
//	public String ShowInspections() 
//	{
//		
//	}
	
	
}
