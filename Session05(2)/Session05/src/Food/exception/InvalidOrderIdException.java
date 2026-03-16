package Food.exception;

public class InvalidOrderIdException extends Exception {
    public InvalidOrderIdException(String id) {
        super("Khong tim thay ID: " + id);
    }
}