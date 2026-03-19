package Bai6;

class PushNotification implements NotificationService {
    @Override
    public void sendNotification(String msg) {
        System.out.println("Push Notification: " + msg);
    }
}
