public class EmailValidationException extends Exception {

    protected EmailValidationException(String errorMessage){
        super(errorMessage);
        System.out.println("Wrong email ID address.");
    }
}
