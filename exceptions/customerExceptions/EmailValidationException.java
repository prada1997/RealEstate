package customerExceptions;

public class EmailValidationException extends Exception {

    public EmailValidationException(String errorMessage){
        super(errorMessage);
        System.out.println("Wrong email ID address.");
    }
}
