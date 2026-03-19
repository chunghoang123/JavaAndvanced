package Bai6;


class OrderService {
    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    // Dependency Injection qua Constructor
    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void processOrder(String product, double price) {
        System.out.println("\n--- Xử lý đơn hàng: " + product + " ---");
        double discountAmount = discount.applyDiscount(price);
        double finalAmount = price - discountAmount;

        System.out.println("Áp dụng giảm giá: " + String.format("%,.0f", discountAmount) + " VNĐ");
        payment.processPayment(finalAmount);
        notification.sendNotification("Đơn hàng " + product + " đã đặt thành công!");
    }
}
