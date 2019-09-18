import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Buyer extends Customer implements Serializable
{

	private ArrayList<String> interestedSuburbs = new ArrayList<String>();
	//private ArrayList<Application> application = new ArrayList<Application>();
	private HashMap<String, Application> applications = new HashMap<String, Application>();
	
	protected Buyer(String customerName,String emailID,String customerType) throws IOException {
		super(customerName, emailID, customerType);
	}
	
	public void addInterest()
	{
		Scanner scan = new Scanner(System.in);
		String ans = null;
		do 
			{
			System.out.println("Enter the interested Suburb: ");
			String sub = scan.nextLine();
			this.interestedSuburbs.add(sub);
			System.out.println("Do you want to enter more Suburb (Yes/No)");
			ans = scan.nextLine();
			}
		while(ans.equalsIgnoreCase("Yes"));
	}
	
	public String addApplication() 
	{
		Scanner scan = new Scanner(System.in);
		Application a;
		
		System.out.println("Enter property name for application:");
		String propertyName = scan.next();
		System.out.println("Enter your income: ");
		double in = scan.nextDouble();
		System.out.println("Enter your past occupation: ");
		String occ = scan.next();
		System.out.println("Enter your current occupation: ");
		String cocc = scan.next();
		System.out.println("Enter your past rental: ");
		int prent = scan.nextInt();
		System.out.println("Enter your current rental: ");
		int crent = scan.nextInt();
		
		a = new Application(in,occ,cocc,prent,crent);
		applications.put(propertyName, a);
		
//		for(int i=0 ; i<application.size();i++)
//        {
//       	 if(application.get(i) == null)
//       	 {
//       		 application.add(a);
//       		 break;
//       	 }
//        }
		return propertyName;
	}

	public HashMap<String, Application> getApplications() {
		return applications;
	}
}
