package Bai5;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo phần cứng
        Light light = new Light();
        AirConditioner ac = new AirConditioner();
        Fan fan = new Fan();
        TemperatureSensor sensor = new TemperatureSensor();

        // Khởi tạo lệnh kịch bản
        Command sleepMode = new SleepModeCommand(light, ac, fan, sensor);

        while (true) {
            System.out.println("\n========= SMART HOME SYSTEM =========");
            System.out.println("1. Nhấn nút 'NGỦ' (Command Macro)");
            System.out.println("2. Giả lập thay đổi nhiệt độ (Observer)");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    sleepMode.execute();
                    break;
                case "2":
                    System.out.print("Nhập nhiệt độ môi trường: ");
                    try {
                        int t = Integer.parseInt(scanner.nextLine());
                        sensor.setTemperature(t);
                    } catch (Exception e) {
                        System.out.println("Lỗi: Vui lòng nhập số!");
                    }
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}