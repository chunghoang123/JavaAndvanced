package Bai1;

public class Main {
    public static void main(String[] args) {
        // BƯỚC 1: Khởi tạo dữ liệu mẫu
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuột", 300000);
        Customer customer = new Customer("Nguyễn Văn A", "a@example.com");

        System.out.println("Tạo sản phẩm: " + p1.id + " - " + p1.name + ", " + p2.id + " - " + p2.name);
        System.out.println("Đã thêm khách hàng " + customer.name);

        // BƯỚC 2: Tạo đơn hàng và thêm sản phẩm
        Order order = new Order("ORD001", customer);
        order.addProduct(p1);
        order.addProduct(p2);
        order.addProduct(p2); // Mua 2 con chuột
        System.out.println("Đơn hàng " + order.orderId + " được tạo");

        // BƯỚC 3: Sử dụng các lớp dịch vụ (Services) để xử lý
        // 1. Tính tiền
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);
        System.out.println("Tổng tiền: " + (long)total);

        // 2. Lưu trữ
        OrderRepository repository = new OrderRepository();
        repository.save(order);

        // 3. Gửi thông báo
        EmailService emailService = new EmailService();
        emailService.sendConfirmation(order);
    }
}
