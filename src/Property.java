import java.io.Serializable;
import java.util.HashMap;

public abstract class Property implements Serializable
{
	private static final long serialVersionUID = 2L;
	private String propertyName;
	private String capacity;
	private String address;
	private String suburb;

	private HashMap<Integer, Application> application = new HashMap<Integer, Application>();
	private HashMap<String, String> Inspection = new HashMap<String, String>();
	private int enteries = 1;
	private String propertyStatus;
	private boolean IsAssign = false;


	public Property(String pName, String address, String suburb, String capacity)
	{
		this.address = address;
		this.suburb = suburb;
		this.propertyName = pName;
		this.capacity = capacity;
		propertyStatus = "Listed";
		initializeInspection();
	}

	public void initializeInspection() {
		Inspection.put("10:45 - 11:00", "Not Booked");
		Inspection.put("11:45 - 12:00", "Not Booked");
		Inspection.put("12:45 - 13:00", "Not Booked");
		Inspection.put("13:45 - 14:00", "Not Booked");
		Inspection.put("14:45 - 15:00", "Not Booked");
	}

	public void setInspection(String time){
		for(String key: Inspection.keySet())
		{
			if(Inspection.keySet().equals("time"))
			{
				Inspection.replace(Inspection.get(key), "Booked");
			}
		}
	}

	public void displayInspection()
	{
		int i = 1;
		for(String key: Inspection.keySet())
		{
			System.out.print("/n " +  + i + key + " 	" + Inspection.get(key));
			i++;
		}
	}

	public void setAssign(boolean assign) {
		IsAssign = assign;
	}

	public boolean isAssign() {
		return IsAssign;
	}

	public boolean addingApplication(Application obj) {

		application.put(enteries, obj);
		enteries++;
		return true;
	}


	public HashMap<Integer, Application> getApplication() {
		return application;
	}


	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public String getPropertyName() {
		return propertyName;
	}
}
