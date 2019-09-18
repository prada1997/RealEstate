import java.io.*;

public class DataInputOutput implements Serializable {
    public void storingData(Customer obj) throws IOException, FileNotFoundException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/data/Customers/");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
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