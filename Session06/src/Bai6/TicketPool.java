package Bai6;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int ticketPrice = 250000;

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i)));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {
            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public int soldCount() {

        int c = 0;

        for (Ticket t : tickets) {
            if (t.isSold()) c++;
        }

        return c;
    }

    public int totalTickets() {
        return tickets.size();
    }

    public int revenue() {
        return soldCount() * ticketPrice;
    }

    public String getRoomName() {
        return roomName;
    }

    public void addTickets(int count) {

        int start = tickets.size() + 1;

        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", start + i)));
        }

        System.out.println("Đã thêm " + count + " vé vào phòng " + roomName);
    }
}