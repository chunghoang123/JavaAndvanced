package Bai5;

class OrderService {

    OrderRepository repository;
    NotificationService notification;

    public OrderService(OrderRepository repository,
                        NotificationService notification) {

        this.repository = repository;
        this.notification = notification;
    }

    public void processOrder(Order order,
                             DiscountStrategy discount,
                             PaymentMethod payment) {

        double total = order.getTotal();

        double discountValue = discount.applyDiscount(total);

        double finalAmount = total - discountValue;

        payment.pay(finalAmount);

        repository.save(order);

        InvoiceGenerator.generate(order, discountValue);

        notification.send("Order success");
    }
}
