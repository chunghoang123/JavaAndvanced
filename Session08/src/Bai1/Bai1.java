package Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Device> myDevices = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị mới");
            System.out.println("3. Bật thiết bị vừa tạo");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Singleton: Luôn trả về cùng một instance
                    HardwareConnection connection = HardwareConnection.getInstance();
                    connection.connect();
                    break;

                case "2":
                    System.out.println("Chọn loại: 1. Đèn, 2. Quạt, 3. Điều hòa");
                    int type = Integer.parseInt(scanner.nextLine());
                    DeviceFactory factory = null;

                    if (type == 1) factory = new LightFactory();
                    else if (type == 2) factory = new FanFactory();
                    else if (type == 3) factory = new AirConditionerFactory();

                    if (factory != null) {
                        myDevices.add(factory.createDevice());
                    }
                    break;

                case "3":
                    if (!myDevices.isEmpty()) {
                        // Lấy thiết bị cuối cùng vừa được thêm vào
                        myDevices.get(myDevices.size() - 1).turnOn();
                    } else {
                        System.out.println("Chưa có thiết bị nào!");
                    }
                    break;

                case "4":
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}