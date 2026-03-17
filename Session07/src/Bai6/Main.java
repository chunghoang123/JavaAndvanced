package Bai6;


import java.util.Scanner;

public class Main{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        OrderService service=new OrderService();

        while(true){

            System.out.println("\n===== CHỌN KÊNH BÁN =====");
            System.out.println("1. Website");
            System.out.println("2. Mobile App");
            System.out.println("3. POS");
            System.out.println("0. Thoát");

            int channel=sc.nextInt();

            SalesChannelFactory factory=null;

            switch(channel){

                case 1:
                    factory=new WebsiteFactory();
                    System.out.println("Bạn đã chọn kênh Website");
                    break;

                case 2:
                    factory=new MobileFactory();
                    System.out.println("Bạn đã chọn kênh Mobile App");
                    break;

                case 3:
                    factory=new POSFactory();
                    System.out.println("Bạn đã chọn kênh POS");
                    break;

                case 0:
                    return;
            }

            System.out.print("Nhập tên sản phẩm: ");
            String name=sc.next();

            System.out.print("Nhập giá: ");
            double price=sc.nextDouble();

            System.out.print("Số lượng: ");
            int qty=sc.nextInt();

            Product p=new Product(name,price);

            Order order=new Order();

            order.addItem(new OrderItem(p,qty));

            DiscountStrategy discount=factory.createDiscount(sc);

            PaymentMethod payment=factory.createPayment(sc);

            NotificationService notify=factory.createNotification();

            service.processOrder(order,discount,payment,notify);
        }
    }
}
