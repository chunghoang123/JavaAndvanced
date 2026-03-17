package Bai5;

class CODPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán khi nhận hàng: " + amount);
    }
}
