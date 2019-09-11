import java.util.ArrayList;
import java.util.HashMap;

public class Property 
{	
	private String propertyName;
	private String address;
	private String suburb;
	private String capacity;
	private String type;
	//private ArrayList<Application> application = new ArrayList<ApplicatiIon>();
	private HashMap<Integer, Application> application = new HashMap<Integer, Application>();
	private int enteries = 1;
	private boolean IsAssign = false;
	PropertyManager Emp;
	
	public Property(String propertyName, String address, String suburb, String capacity, String type) 
	{
		this.propertyName= propertyName;
		this.address = address;
		this.suburb = suburb;
		this.capacity = capacity;
		this.type = type;
	}
	
	
	public boolean addingAplication(Application obj) {
		
		application.put(1, obj);
		
//		for(int i=0 ; i<application.size();i++)
//        {
//       	 if(application.get(i) == null)
//       	 {
//       		 application.add(obj);
//       		 break;
//       	 }
//        }
		
		return true;
	}
	
	public String showApplication() {
		String details = "\n";
		 
		for( int id : application.keySet()) {
			details = application.get(id).display();
			return details;
		}
		return "no application";
	}
}
