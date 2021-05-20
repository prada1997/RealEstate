import java.io.Serializable;
import java.util.Scanner;

public class Finance implements Serializable {
    private final double hourlyRate = 25;
    //private final double fullTimeFortnitelyHour = 80;

    protected Finance(){

    }

    public double fullTimePayRoll(double workingHour){
        double netPay = 0.00;
                netPay = hourlyRate * workingHour;
                return netPay;

}

    public double partTimePayRoll(){
        double netPay = 0.00;
            netPay = addHours() * hourlyRate;
            return netPay;

    }


    public double addHours(){
        double hours;
        System.out.println("For Part Time employee \nEnter number of hours.\n");
        hours = new Scanner(System.in).nextDouble();
        return hours;
    }
}
