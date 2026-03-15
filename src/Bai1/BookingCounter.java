package Bai1;

public class BookingCounter {
    private String name;
    private TicketPool roomA;
    private TicketPool roomB;
    private boolean LockAFirst;


    public BookingCounter(String name, TicketPool roomA, TicketPool roomB, boolean lockAFirst) {
        this.name = name;
        this.roomA = roomA;
        this.roomB = roomB;
        LockAFirst = lockAFirst;
    }

    public void sellCombo() {
//        TicketPool fisrt   = LockAFirst ? roomA : roomB;
//        TicketPool second  = LockAFirst ? roomB : roomA;
//
//        synchronized (fisrt){
//            String ticket1 = fisrt.getTicket();
//            System.out.println(name + ": Đã lấy vé " + ticket1);
//           try{
//               Thread.sleep(1000);
//           }catch (Exception e){}
//           System.out .println(name  + " : Dang cho ve "+ ticket1);
//
//           synchronized (second){
//               String ticket2 = second.getTicket();
//               if(ticket1 != null && ticket2 != null){
//                   System.out.println(name + ": Ban combo thanh cong " + ticket1 + " và " + ticket2);
//               }else {
//                   System.out.println(name  + "ban that bai");
//                   fisrt.returnTicket(ticket1);
//                   second.returnTicket(ticket2);
//
//               }
//
//            }
//        }
//    }
        synchronized (roomA) {

            synchronized (roomB) {

                String ticketA = roomA.getTicket();
                String ticketB = roomB.getTicket();

                if (ticketA != null && ticketB != null) {
                    System.out.println(name + " bán combo thành công: " + ticketA + " & " + ticketB);
                } else {

                    System.out.println(name + ": Hết vé, bán combo thất bại");

                    roomA.returnTicket(ticketA);
                    roomB.returnTicket(ticketB);
                }
            }
        }
    }
    public void run(){
        sellCombo();
    }
}
