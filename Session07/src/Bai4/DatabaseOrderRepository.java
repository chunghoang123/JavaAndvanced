package Bai4;

public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void save(String orderId) {
        System.out.println("Lưu đơn hàng vào database: " + orderId);
    }
}