package Bai4;

public class EmailService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi email đến " + recipient + ": " + message);
    }
}