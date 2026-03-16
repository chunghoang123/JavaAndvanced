package Food.exception;

public class InsufficientStockException extends Exception {
    public InsufficientStockException(String itemName, int available) {
        super("Mon [" + itemName + "] khong du hang! Con lai: " + available);
    }
}