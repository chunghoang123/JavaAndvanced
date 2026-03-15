package Bai2;

public class BookingCounter extends Thread {

    private TicketPool pool;
    private String room;

    public BookingCounter(String name, TicketPool pool, String room) {
        super(name);
        this.pool = pool;
        this.room = room;
    }

    public void run() {
        while (true) {
            String ticket = pool.sellTicket(room, getName());
            System.out.println(getName() + " bán vé " + ticket);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}