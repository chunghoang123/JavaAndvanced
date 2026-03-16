package Bai1;

public class EmailService {
    public void sendConfirmation(Order order){
        System.out.println("da gui mail de " + order.customer.email + ": Don hang " + order.orderId + "da duoc tao");
    }

}
