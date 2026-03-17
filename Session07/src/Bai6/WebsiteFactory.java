package Bai6;

import java.util.Scanner;

class WebsiteFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount(Scanner sc) {

        System.out.print("Nhập mã giảm giá: ");
        String code = sc.next();

        return new WebsiteDiscount(code);
    }

    public PaymentMethod createPayment(Scanner sc) {

        System.out.println("1. Thẻ tín dụng");
        int choice = sc.nextInt();

        return new CreditCardPayment();
    }

    public NotificationService createNotification() {
        return new EmailNotification();
    }
}
