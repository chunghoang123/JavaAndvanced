package Bai6;

class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toán Thẻ tín dụng: " + String.format("%,.0f", amount) + " VNĐ");
    }
}
