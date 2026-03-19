package Bai4;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo Subject
        TemperatureSensor sensor = new TemperatureSensor();

        // Khởi tạo Observers
        Fan smartFan = new Fan();
        Humidifier smartHumidifier = new Humidifier();

        while (true) {
            System.out.println("\n--- HỆ THỐNG CẢM BIẾN THÔNG MINH ---");
            System.out.println("1. Đăng ký Quạt & Máy tạo ẩm");
            System.out.println("2. Thay đổi nhiệt độ (Set Temperature)");
            System.out.println("3. Hủy đăng ký Quạt");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    sensor.attach(smartFan);
                    smartFan.registerInfo();
                    sensor.attach(smartHumidifier);
                    smartHumidifier.registerInfo();
                    break;

                case "2":
                    System.out.print("Nhập nhiệt độ mới: ");
                    try {
                        int temp = Integer.parseInt(scanner.nextLine());
                        sensor.setTemperature(temp);
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số nguyên!");
                    }
                    break;

                case "3":
                    sensor.detach(smartFan);
                    System.out.println("Hệ thống: Quạt đã ngừng theo dõi nhiệt độ.");
                    break;

                case "4":
                    System.out.println("Kết thúc chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}