import java.io.Serializable;

public class BranchAdmin extends Employee implements Serializable {

    protected BranchAdmin(String employeeName, String email, String designation, String emptype)
    {
        super(employeeName, email, designation, emptype);

    }
}
