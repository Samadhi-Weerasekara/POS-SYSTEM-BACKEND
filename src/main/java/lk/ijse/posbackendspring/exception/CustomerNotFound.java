package lk.ijse.posbackendspring.exception;

public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound() {

    }

    public CustomerNotFound(String message) {
        super(message);
    }

    public CustomerNotFound(String message, Throwable cause) {

    }
}
