import java.io.IOException;
import java.util.HashMap;

public class Record {

    public static HashMap<String, Customer> customerRecord = new HashMap<String, Customer>();
    public static HashMap<String, Employee> employeeRecord =  new HashMap<String, Employee>();

    //is hashmap storing obj of all the customer.
    protected Record(Customer obj) throws IOException {
        customerRecord.put(obj.getUniqueID(),obj);
        new DataInputOutput().storingCustomer(obj);
    }

    //public void

}
