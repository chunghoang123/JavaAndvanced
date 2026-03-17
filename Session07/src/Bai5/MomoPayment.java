package Bai5;

class MomoPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán bằng MoMo: " + amount);
    }
}
