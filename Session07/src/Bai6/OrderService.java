package Bai6;

class OrderService {

    public void processOrder(Order order,
                             DiscountStrategy discount,
                             PaymentMethod payment,
                             NotificationService notify) {

        double total = order.getTotal();

        double discountValue = discount.apply(total);

        double finalAmount = total - discountValue;

        System.out.println("Tổng tiền: " + total);
        System.out.println("Giảm giá: " + discountValue);
        System.out.println("Thanh toán: " + finalAmount);

        payment.pay(finalAmount);

        notify.notifyUser();
    }
}
