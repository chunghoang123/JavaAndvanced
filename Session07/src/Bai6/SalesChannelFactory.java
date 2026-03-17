package Bai6;

import java.util.Scanner;

interface SalesChannelFactory {

    DiscountStrategy createDiscount(Scanner sc);

    PaymentMethod createPayment(Scanner sc);

    NotificationService createNotification();
}
