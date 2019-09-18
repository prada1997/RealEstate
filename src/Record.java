import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class Record implements Serializable {

    public static HashMap<String, Customer> customerRecord = new HashMap<String, Customer>();
    public static HashMap<String, Employee> employeeRecord =  new HashMap<String, Employee>();

    protected Record(Customer obj) throws IOException {
        customerRecord.put(obj.getUniqueID(),obj);
        new DataInputOutput().storingData(obj);
    }

}
