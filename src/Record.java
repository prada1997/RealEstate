import java.io.Serializable;
import java.util.HashMap;

public class Record implements Serializable {
    private static final long serialVersionUID = 1L;
    private static HashMap<String, Customer> customerRecord = new HashMap<>();
    private static HashMap<String, Employee> employeeRecord =  new HashMap<>();
    private static HashMap<String, Property> PropertyRecord =  new HashMap<>();


    protected Record() {

    }


    protected Record (Customer obj) {
        customerRecord.put(obj.getCustomerId(),obj);
        new DataInputOutput().storingCustomer(obj);
    }

    protected Record (Employee obj) {
        employeeRecord.put(obj.getEid(),obj);
        new DataInputOutput().storingEmployee(obj);
    }


    protected Record(Property obj)
    {
        PropertyRecord.put(obj.getPropertyName(),obj);
        new DataInputOutput().storingProperty(obj);
    }


    protected Record(String state) {
        if (state.equals("terminate")) {
            new DataInputOutput().storingCustomerRecord(customerRecord);
            //new DataInputOutput().storingEmployeeRecord(employeeRecord);
            new DataInputOutput().storingPropertyRecord(PropertyRecord);
        }
        //load file at the start of the program
        else if (state.equals("start")) {
           setCustomerRecord(new DataInputOutput().fetchingCustomerRecord());
//            //setEmployeeRecord(new DataInputOutput().fetchingEmployeeRecord());
            setPropertyRecord(new DataInputOutput().fetchingPropertyRecord());
        }
    }


    public void setCustomerRecord(HashMap<String, Customer> customerRecord) {
        Record.customerRecord = customerRecord;
    }


    public HashMap<String, Customer> getCustomerRecord() {
        return customerRecord;
    }


    public HashMap<String, Employee> getEmployeeRecord() {
        return employeeRecord;
    }


    public void setEmployeeRecord(HashMap<String, Employee> employeeRecord) {
        Record.employeeRecord = employeeRecord;
    }


    public HashMap<String, Property> getPropertyRecord() {
        return PropertyRecord;
    }

    public static void setPropertyRecord(HashMap<String, Property> propertyRecord) {
        PropertyRecord = propertyRecord;
    }
}
