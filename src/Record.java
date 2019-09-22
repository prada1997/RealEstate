import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class Record implements Serializable {
    private static final long serialVersionUID = 1L;
    private static HashMap<String, Customer> customerRecord = new HashMap<>();
    private static HashMap<String, Employee> employeeRecord =  new HashMap<>();


    protected Record() {

    }


    protected Record (Customer obj) {
        customerRecord.put(obj.getEmailID(),obj);
        new DataInputOutput().storingCustomer(obj);
    }

    protected Record (Employee obj) {
        employeeRecord.put(obj.getEmail(),obj);
        new DataInputOutput().storingEmployee(obj);
    }


    protected Record(String state) {
        if (state.equals("terminate")) {
            new DataInputOutput().storingCustomerRecord(customerRecord);
            new DataInputOutput().storingEmployeeRecord(employeeRecord);
        }
        //load file at the start of the program
        else if (state.equals("start")) {
            setCustomerRecord(new DataInputOutput().fetchingCustomerRecord());
            setEmployeeRecord(new DataInputOutput().fetchingEmployeeRecord());
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
}
