package Bai4;

public class SMSNotification implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi SMS đến " + recipient + ": " + message);
    }
}