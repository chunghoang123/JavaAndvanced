package Bai3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo thiết bị
        Light livingRoomLight = new Light();
        AirConditioner ac = new AirConditioner();

        // Khởi tạo Remote có 5 nút
        RemoteControl remote = new RemoteControl(5);

        while (true) {
            System.out.println("\n--- REMOTE CONTROL MENU ---");
            System.out.println("1. Gán nút 1: Bật đèn");
            System.out.println("2. Gán nút 2: Tắt đèn");
            System.out.println("3. Gán nút 3: Set điều hòa 26°C");
            System.out.println("4. Nhấn nút (1/2/3)");
            System.out.println("5. Nhấn Undo");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    remote.setCommand(0, new LightOnCommand(livingRoomLight));
                    break;
                case "2":
                    remote.setCommand(1, new LightOffCommand(livingRoomLight));
                    break;
                case "3":
                    remote.setCommand(2, new ACSetTemperatureCommand(ac, 26));
                    break;
                case "4":
                    System.out.print("Nhấn nút số mấy? ");
                    int slot = Integer.parseInt(scanner.nextLine()) - 1;
                    remote.pressButton(slot);
                    break;
                case "5":
                    remote.pressUndo();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}