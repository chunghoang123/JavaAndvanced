package Bai4;

public class OrderService {
    private final OrderRepository repository;
    private final NotificationService notification;

    // Constructor Injection: Tiêm "sự phụ thuộc" từ bên ngoài vào
    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(String orderId, String contact) {
        // Gọi phương thức từ interface, không quan tâm là File hay DB
        repository.save(orderId);
        notification.send("Đơn hàng " + orderId + " đã được tạo", contact);
    }
}