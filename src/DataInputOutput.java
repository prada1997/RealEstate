import java.io.*;

public class DataInputOutput implements Serializable {

    //use of try and catch with finally to close the stream or multiple catch for each exception type
    public void storingCustomer(Customer obj) throws IOException, FileNotFoundException {

        ObjectOutputStream output = new ObjectOutputStream(
                    new FileOutputStream("data/Customers/"+ obj.getUniqueID() + ".txt"));
        output.writeObject(obj);
        output.flush();
        output.close();
    }


    public void storingRecord(Record obj) throws  IOException {
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("data/CustomerRecord.txt"));
        output.writeObject(obj);
        output.flush();
        output.close();
    }
}