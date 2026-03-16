package Bai4;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Cấu hình 1 ---");
        OrderRepository fileRepo = new FileOrderRepository();
        NotificationService emailSvc = new EmailService();

        OrderService service1 = new OrderService(fileRepo, emailSvc);
        service1.createOrder("ORD001", "customer@example.com");


        // Chứng minh: Không sửa 1 dòng code nào trong OrderService.java
        System.out.println("\n--- Cấu hình 2 (Thay thế linh hoạt) ---");
        OrderRepository dbRepo = new DatabaseOrderRepository();
        NotificationService smsSvc = new SMSNotification();

        OrderService service2 = new OrderService(dbRepo, smsSvc);
        service2.createOrder("ORD002", "0901234567");
    }
}