import java.util.HashMap;
import java.util.Random;

public class Property 
{	
	private int propertId;
	private String address;
	private String suburb;
	private String capacity;
	private String type;

	private HashMap<Integer, Application> application = new HashMap<Integer, Application>();
	private int enteries = 1;
	private String propertyStatus;
	private boolean IsAssign = false;
	PropertyManager Emp;
	
	public Property(String address, String suburb, String capacity, String type)
	{
		this.address = address;
		this.suburb = suburb;
		this.capacity = capacity;
		this.type = type;
		propertId =  generateID();
	}


	public int generateID()
	{	int randNum;
		Random rand = new Random();
		randNum = rand.nextInt(100);
		return randNum;
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
