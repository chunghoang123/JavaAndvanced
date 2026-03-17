package Bai6;

import java.util.Scanner;

class MobileFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount(Scanner sc) {

        System.out.print("Lần đầu mua? (true/false): ");
        boolean first = sc.nextBoolean();

        return new MobileDiscount(first);
    }

    public PaymentMethod createPayment(Scanner sc) {

        System.out.println("1. Ví MoMo");
        sc.nextInt();

        return new MomoPayment();
    }

    public NotificationService createNotification() {
        return new PushNotification();
    }
}
