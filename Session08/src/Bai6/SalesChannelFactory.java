package Bai6;

interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();

    PaymentMethod createPaymentMethod();

    NotificationService createNotificationService();
}
