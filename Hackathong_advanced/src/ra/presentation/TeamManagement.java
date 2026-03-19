package ra.presentation;

import ra.business.TeamBusiness;
import java.util.Scanner;

public class TeamManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamBusiness bus = TeamBusiness.getInstance();

        while (true) {
            try {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Hiển thị");
                System.out.println("2. Thêm");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Tìm kiếm");
                System.out.println("6. Ứng viên vô địch");
                System.out.println("7. Sắp xếp");
                System.out.println("8. Thoát");

                System.out.print("Chọn: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        bus.displayAll();
                        break;
                    case 2:
                        bus.add(sc);
                        break;
                    case 3:
                        bus.update(sc);
                        break;
                    case 4:
                        System.out.print("Nhập ID: ");
                        bus.delete(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Nhập từ khóa: ");
                        bus.search(sc.nextLine());
                        break;
                    case 6:
                        bus.findChampion();
                        break;
                    case 7:
                        bus.sortDesc();
                        break;
                    case 8:
                        System.out.println("Thoát!");
                        return;
                    default:
                        System.out.println("Chọn sai!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi nhập! Không được nhập chữ!");
            }
        }
    }
}