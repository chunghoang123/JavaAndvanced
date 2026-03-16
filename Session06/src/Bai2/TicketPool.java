package Bai2;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private Queue<String> roomA = new LinkedList<>();
    private Queue<String> roomB = new LinkedList<>();

    public TicketPool() {
        for (int i = 1; i <= 5; i++) {
            roomA.add("A-00" + i);
            roomB.add("B-00" + i);
        }
    }

    public synchronized String sellTicket(String room, String counterName) {

        Queue<String> targetRoom = room.equals("A") ? roomA : roomB;

        while (targetRoom.isEmpty()) {
            try {
                System.out.println(counterName + ": Hết vé phòng " + room + ", đang chờ...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String ticket = targetRoom.poll();
        return ticket;
    }

    public synchronized void addTickets(String room, int quantity) {

        Queue<String> targetRoom = room.equals("A") ? roomA : roomB;

        int start = targetRoom.size() + 10;

        for (int i = 0; i < quantity; i++) {
            targetRoom.add(room + "-" + (start + i));
        }

        System.out.println("Nhà cung cấp: Đã thêm " + quantity + " vé vào phòng " + room);

        notifyAll();
    }
}