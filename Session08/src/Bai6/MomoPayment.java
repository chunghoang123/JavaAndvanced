package Bai6;

class MomoPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toán MoMo: " + String.format("%,.0f", amount) + " VNĐ");
    }
}
