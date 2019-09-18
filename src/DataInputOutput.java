import java.io.*;

public class DataInputOutput implements Serializable {
    public void storingData(Customer obj) throws IOException, FileNotFoundException {
        try {
            //FileOutputStream fileOutputStream = ;
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Customers/"+ obj.getUniqueID() + ".txt"));
            out.writeObject(obj);
            out.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}