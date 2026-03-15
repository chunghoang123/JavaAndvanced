package Bai6;

import java.util.*;

public class BookingCounter implements Runnable {

    private String name;
    private List<TicketPool> pools;
    private volatile boolean running = true;
    private volatile boolean paused = false;

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public void stop() {
        running = false;
    }

    public void run() {

        Random rand = new Random();

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            if (paused) {
                try { Thread.sleep(500); } catch (Exception e) {}
                continue;
            }

            TicketPool pool = pools.get(rand.nextInt(pools.size()));
            Ticket t = pool.sellTicket();

            if (t != null) {
                System.out.println(name + " đã bán vé " + t.getId());
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}