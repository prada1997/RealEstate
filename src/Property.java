import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

public abstract class Property implements Serializable
{	
	private String propertyName;
	private String address;
	private String suburb;
	private String capacity;
	private String type;

	private HashMap<Integer, Application> application = new HashMap<Integer, Application>();
	private int enteries = 1;
	private String propertyStatus;
	private boolean IsAssign = false;
	PropertyManager Employee;
	Customer owner;


	public Property(String ownerID, String pName, String address, String suburb, String capacity, String type)
	{
		String ID = ownerID;
		this.owner = new Record().getCustomerRecord().get(ID);

		this.propertyName = pName;
		this.address = address;
		this.suburb = suburb;
		this.capacity = capacity;
		this.type = type;
		propertyStatus = "Listed";
	}

	
	public boolean addingApplication(Application obj) {

		application.put(enteries, obj);
		enteries++;
		return true;
	}


	public Customer getOwner() {
		return owner;
	}

	public HashMap<Integer, Application> getApplication() {
		return application;
	}

	public Application fetchApplication(int i) {
		return application.get(i);
	}

	public abstract boolean formalOffer();

	public String showApplication() {
		String details = "\n";
		 
		for( int id : application.keySet()) {
			details = application.get(id).display();
			return details;
		}
		return "no application";
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
