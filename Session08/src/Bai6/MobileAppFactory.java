package Bai6;

class MobileAppFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscountStrategy() {
        return new MobileFirstTimeDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}
