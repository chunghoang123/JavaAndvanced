package Bai2;

public class Supplier extends Thread {

    private TicketPool pool;

    public Supplier(TicketPool pool) {
        this.pool = pool;
    }

    public void run() {

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pool.addTickets("A", 3);
    }
}