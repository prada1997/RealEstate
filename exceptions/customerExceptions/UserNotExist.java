package customerExceptions;

public class UserNotExist extends Exception {
    protected UserNotExist(String message){
        super(message);
    }
}
