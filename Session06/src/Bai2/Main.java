package Bai2;
public class Main {

    public static void main(String[] args) {

        TicketPool pool = new TicketPool();

        BookingCounter counter1 = new BookingCounter("Quầy 1", pool, "A");
        BookingCounter counter2 = new BookingCounter("Quầy 2", pool, "B");

        Supplier supplier = new Supplier(pool);

        counter1.start();
        counter2.start();
        supplier.start();
    }
}