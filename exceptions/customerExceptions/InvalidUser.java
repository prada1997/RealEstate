package customerExceptions;

public class InvalidUser extends Exception {
    public InvalidUser(String message){
        super(message);
    }
}
