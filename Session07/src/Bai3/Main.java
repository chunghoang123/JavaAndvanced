package Bai3;

public class Main {
    public static void main(String[] args) {
        // 1. Thanh toán COD
        PaymentMethod cod = new CODPayment();
        PaymentProcessor processor1 = new PaymentProcessor(cod);
        processor1.process(500000);

        // 2. Thanh toán Thẻ tín dụng
        PaymentMethod card = new CreditCardPayment();
        PaymentProcessor processor2 = new PaymentProcessor(card);
        processor2.process(1000000);

        // 3. Thanh toán MoMo
        PaymentMethod momo = new MomoPayment();
        PaymentProcessor processor3 = new PaymentProcessor(momo);
        processor3.process(750000);

        // --- KIỂM TRA LSP ---
        System.out.println("\n--- Kiểm tra LSP ---");
        // Ta có thể thay thế CreditCardPayment bằng MomoPayment
        // mà không làm thay đổi cách thức hoạt động của PaymentProcessor
        PaymentMethod replacement = new MomoPayment();
        PaymentProcessor lspProcessor = new PaymentProcessor(replacement);

        // Chương trình vẫn chạy đúng với đối tượng thay thế
        lspProcessor.process(1000000);
    }
}