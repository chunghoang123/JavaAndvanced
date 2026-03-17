package Bai6;

import java.util.Scanner;

class POSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount(Scanner sc) {

        System.out.print("Có phải thành viên? (true/false): ");
        boolean member = sc.nextBoolean();

        return new POSDiscount(member);
    }

    public PaymentMethod createPayment(Scanner sc) {

        System.out.println("1. Tiền mặt");
        sc.nextInt();

        return new CashPayment();
    }

    public NotificationService createNotification() {
        return new PrintInvoice();
    }
}
