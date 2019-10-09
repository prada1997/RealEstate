import java.util.HashMap;

public class Sales extends Property
{
	private double minprice;
	private double DownPayment = minprice * 0.1;
	//private HashMap<String , >
	
	public Sales(String address, String suburb, String capacity, String type, double minprice)
	{
		super( address, suburb, capacity, type);
		this.minprice = minprice;
	}
	
	public void FormalOffer() 
	{
		
	}
	
	public void DownPayment() 
	{
		
	}
	
	public void FinalizeProperty() 
	{
		
	}
	
//	public void SetAgent(SalesConsultant Emp) 
//	{
//		super.Emp = Emp;
//		super.IsAssign = true;
//	}
	
	public void AddInspections() 
	{
		
	}
	
//	public String ShowInspections() 
//	{
//		
//	}

}
