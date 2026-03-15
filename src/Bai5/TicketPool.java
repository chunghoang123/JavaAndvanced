package Bai5;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket holdTicket(boolean vip, String counterName) {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (!t.isSold() && !t.isHeld()) {

                t.setHeld(true);
                t.setVIP(vip);
                t.setHoldExpiryTime(now + 5000);

                System.out.println(counterName +
                        ": Đã giữ vé " + t.getTicketId() +
                        (vip ? " (VIP)" : "") +
                        ". Vui lòng thanh toán trong 5s");

                return t;
            }
        }

        return null;
    }

    public synchronized boolean sellHeldTicket(Ticket ticket, String counterName) {

        if (ticket == null) return false;

        if (ticket.isHeld() && !ticket.isSold()) {

            ticket.setSold(true);
            ticket.setHeld(false);

            System.out.println(counterName +
                    ": Thanh toán thành công vé " +
                    ticket.getTicketId());

            return true;
        }

        return false;
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld() && !t.isSold() && now > t.getHoldExpiryTime()) {

                t.setHeld(false);

                System.out.println(
                        "TimeoutManager: Vé " +
                                t.getTicketId() +
                                " hết hạn giữ, đã trả lại kho"
                );
            }
        }
    }
}