package Bai5;

class VNPayPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán bằng VNPay: " + amount);
    }
}
