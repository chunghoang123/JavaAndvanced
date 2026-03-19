package Bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        // Khởi tạo các thành phần hệ thống
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // Cảm biến cũ được "bọc" trong Adapter
        OldThermometer oldSensor = new OldThermometer();
        TemperatureSensor adapter = new ThermometerAdapter(oldSensor);

        // Khởi tạo Facade - Điểm truy cập duy nhất cho Client
        SmartHomeFacade smartHome = new SmartHomeFacade(light, fan, ac, adapter);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- SMART HOME FACADE MENU ---");
            System.out.println("1. Xem nhiệt độ hiện tại (Adapter)");
            System.out.println("2. Chế độ rời nhà (Facade)");
            System.out.println("3. Chế độ ngủ (Facade)");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    smartHome.displayCurrentTemperature();
                    break;
                case "2":
                    smartHome.leaveHome();
                    break;
                case "3":
                    smartHome.sleepMode();
                    break;
                case "4":
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}