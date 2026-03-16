package Bai6;

import java.util.*;
import java.util.concurrent.*;

public class CinemaSystem {

    private List<TicketPool> pools = new ArrayList<>();
    private List<BookingCounter> counters = new ArrayList<>();
    private ExecutorService executor;

    public void start(int rooms, int ticketsPerRoom, int counterCount) {

        pools.clear();
        counters.clear();

        for (int i = 0; i < rooms; i++) {

            char roomName = (char) ('A' + i);
            pools.add(new TicketPool(String.valueOf(roomName), ticketsPerRoom));
        }

        executor = Executors.newFixedThreadPool(counterCount);

        for (int i = 1; i <= counterCount; i++) {

            BookingCounter counter =
                    new BookingCounter("Quầy " + i, pools);

            counters.add(counter);
            executor.submit(counter);
        }

        System.out.println("Đã khởi tạo hệ thống với "
                + rooms + " phòng, "
                + (rooms * ticketsPerRoom) + " vé, "
                + counterCount + " quầy");
    }

    public void pause() {

        for (BookingCounter c : counters) {
            c.pause();
        }

        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void resume() {

        for (BookingCounter c : counters) {
            c.resume();
        }

        System.out.println("Đã tiếp tục hoạt động.");
    }

    public void stats() {

        System.out.println("=== THỐNG KÊ HIỆN TẠI ===");

        int totalRevenue = 0;

        for (TicketPool p : pools) {

            System.out.println("Phòng " + p.getRoomName() +
                    ": Đã bán " + p.soldCount() +
                    "/" + p.totalTickets() + " vé");

            totalRevenue += p.revenue();
        }

        System.out.println("Tổng doanh thu: " + totalRevenue + " VNĐ");
    }

    public void addTickets(int roomIndex, int count) {

        if (roomIndex < pools.size()) {
            pools.get(roomIndex).addTickets(count);
        }
    }

    public void stop() {

        for (BookingCounter c : counters) {
            c.stop();
        }

        executor.shutdownNow();

        System.out.println("Đang dừng hệ thống...");
    }
}