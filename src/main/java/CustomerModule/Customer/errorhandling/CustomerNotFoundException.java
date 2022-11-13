package CustomerModule.Customer.errorhandling;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomerNotFoundException(){

    }
}
