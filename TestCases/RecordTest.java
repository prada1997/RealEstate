import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;

class TestRecord {
    /*public static SandERealEstate object;
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        object = new SandERealEstate();
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("\n");
    }

    @Test
    void customerFileSaveTest() throws Exception {
        //creating  of Customer Class.
        //Customer store = new Customer("deter","dexter@gmail.com","buyer");
        //Changing the Customer id.
        store.setCustomerId("test");
        //sending to the constructor of Record to save it into file.
        new Record(store);
        //fetching from the file.
        Customer rec = new DataInputOutput().fetchingCustomer("test");
        //the value received from file.
        String expected = rec.getCustomerId();
        //the value which is stored in the file.
        String actual = store.getCustomerId();

        assertEquals(expected, actual);

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void applicationUserTest() throws customerExceptions.InvalidUser {
        //created the object of Customer class.
        Customer vendor = new Customer("abc","abc","vendor");
        //throw Invalid user exception, if un desired user trying to access the method
        thrown.expect(customerExceptions.InvalidUser.class);
        //calling add application method.
        SandERealEstate.addApplication(vendor);
    }

    @Test
    public void customerRecordTest() throws Exception{
        //creating the object of Employee class.
        Employee employee = new Employee("dexter","dexter@gmail.com","branch admin","full time");
        //storing the employee object into HashMap using Record class constructor
        new Record(employee);
        //Size of HashMap before storing it into the file.
        int beforeFile = new Record().getCustomerRecord().size();
        //storing the employeeRecord HashMap into the file.
        new DataInputOutput().storingEmployeeRecord(new Record().getEmployeeRecord());
        //fetching the file and storing the size of HashMap
        int afterFile = new DataInputOutput().fetchingEmployeeRecord().size();

        assertEquals(afterFile,beforeFile);
    }

    @Test
    public void UserLoginTest() throws customerExceptions.UserNotExist {
        //created the object of Customer class.
        Customer vendor = new Customer("abhi","abhi@outlook.com","vendor");
        HashMap<String, Customer> users = new HashMap<>();
        users.put("abhi@outlook.com",vendor);
        //stored the customer object in HashMap by using Record class object.
        new Record().setCustomerRecord(users);
        //throw Invalid user not exist exception, if un desired user trying to access the method
        thrown.expect(customerExceptions.UserNotExist.class);
        //calling add checkCustomerUser method to check those user exist or not
        //object.checkCustomerUser("dexter@gmail.com","dexter");

    }*/

}
