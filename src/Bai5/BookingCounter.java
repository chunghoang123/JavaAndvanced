package Bai5;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool[] pools;

    private Random random = new Random();

    public BookingCounter(String counterName, TicketPool[] pools) {
        this.counterName = counterName;
        this.pools = pools;
    }

    public void run() {

        while (true) {

            int roomIndex = random.nextInt(pools.length);
            boolean vip = random.nextBoolean();

            Ticket ticket = pools[roomIndex].holdTicket(vip, counterName);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pools[roomIndex].sellHeldTicket(ticket, counterName);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}