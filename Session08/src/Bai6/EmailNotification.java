package Bai6;

class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String msg) {
        System.out.println("Email: " + msg);
    }
}
