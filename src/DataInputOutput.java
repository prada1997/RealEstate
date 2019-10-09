import java.io.*;
import java.util.HashMap;

public class DataInputOutput implements Serializable {

    //use of try and catch with finally to close the stream or multiple catch for each exception type
    public void storingCustomer(Customer obj) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("data/Customers/" + obj.getCustomerId() + ".txt"));
            output.writeObject(obj);
            output.flush();
            output.close();
        }

        catch (Exception e){
            System.out.println(e);
        }
}

    public Customer fetchingCustomer(String fileName) {
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("data/Customers/" + fileName + ".txt"));

            return (Customer) input.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }


    public void storingEmployee(Employee obj) {
        try{
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("data/Employees/" + obj.getEid() + ".txt"));

            output.writeObject(obj);
            output.flush();
            output.close();
        }

        catch (Exception e){
            System.out.println(e);
        }
    }

   /* public Employee fetchingEmployee(String fileName) {
        try {
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("data/Employees/" + fileName + ".txt"));

            return (Customer) input.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }*/

    public void storingCustomerRecord(HashMap<String, Customer> obj) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("data/CustomerRecord.txt"));

            output.writeObject(obj);
            output.flush();
            output.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public HashMap<String, Customer> fetchingCustomerRecord( ) {
        try{
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("data/CustomerRecord.txt"));

            return (HashMap) input.readObject();
        }

        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public void storingEmployeeRecord(HashMap obj) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("data/EmployeeRecord.txt"));
            output.writeObject(obj);
            output.flush();
            output.close();

        }

        catch (Exception e) {
            System.out.println(e);
        }
    }

    public HashMap fetchingEmployeeRecord( ) {
        try{
            ObjectInputStream input = new ObjectInputStream(
                    new FileInputStream("data/EmployeeRecord.txt"));

            return (HashMap) input.readObject();
        }

        catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

}
