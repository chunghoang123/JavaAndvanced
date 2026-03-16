package Bai3;

public class PaymentProcessor {
    private PaymentMethod paymentMethod;

    // Nhận vào một interface chung
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        paymentMethod.pay(amount);
    }
}