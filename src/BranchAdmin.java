import java.io.Serializable;
import java.util.HashMap;

public class BranchAdmin extends Employee implements Serializable {

    protected BranchAdmin(String employeeName, String email, String designation, String emptype)
    {
        super(employeeName, email, designation, emptype);

    }

    public void initiatePayRoll(){
        HashMap<String, Employee> list = new Record().getEmployeeRecord();
        Finance obj = new Finance();
        for (String key : list.keySet() ){
            double netPay;
           // System.out.println("Employee name:");
            if(list.get(key).getEmployeeType().equals("full time")) {
                netPay = obj.fullTimePayRoll(list.get(key).getWorkingHour());
                if (netPay > -1) {
                    list.get(key).setSalary(netPay);
                }
            }
            else if(list.get(key).getEmployeeType().equals("part time")){
                netPay = obj.partTimePayRoll();
                if (netPay > -1) {
                    list.get(key).setSalary(netPay);
                }
            }
        }
    }

}
