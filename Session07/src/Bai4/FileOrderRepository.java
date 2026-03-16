package Bai4;

public class FileOrderRepository implements OrderRepository {
    @Override
    public void save(String orderId) {
        System.out.println("Lưu đơn hàng vào file: " + orderId);
    }
}
