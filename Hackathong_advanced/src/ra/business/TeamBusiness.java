package ra.business;

import ra.entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamBusiness {
    private static TeamBusiness instance;
    private List<Team> list = new ArrayList<>();

    private TeamBusiness() {}

    public static TeamBusiness getInstance() {
        if (instance == null) {
            instance = new TeamBusiness();
        }
        return instance;
    }

    // hiển thị
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("+-------+----------------------+-------+----------+");
        System.out.println("| ID    | Tên đội              | SL    | AvgWeight|");
        System.out.println("+-------+----------------------+-------+----------+");
        list.forEach(Team::displayData);
        System.out.println("+-------+----------------------+-------+----------+");
    }

    // check trùng
    public boolean isDuplicate(String id) {
        return list.stream()
                .anyMatch(t -> t.getTeamId().equalsIgnoreCase(id));
    }

    // thêm
    public void add(Scanner sc) {
        do {
            Team t = new Team();
            t.inputData(sc);

            if (isDuplicate(t.getTeamId())) {
                System.out.println("Trùng ID!");
            } else {
                list.add(t);
                System.out.println("Thêm thành công!");
            }

            System.out.print("Tiếp tục thêm? (y/n): ");
        } while (sc.nextLine().equalsIgnoreCase("y"));
    }

    // tìm theo id
    public Team findById(String id) {
        return list.stream()
                .filter(t -> t.getTeamId().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    // cập nhật từng field
    public void update(Scanner sc) {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        Team t = findById(id);
        if (t == null) {
            System.out.println("Không tồn tại!");
            return;
        }

        int choice;
        do {
            System.out.println("1. Tên đội");
            System.out.println("2. Số thành viên");
            System.out.println("3. Cân nặng TB");
            System.out.println("0. Thoát");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Tên mới: ");
                    t.setTeamName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Số thành viên: ");
                    t.setMemberCount(Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    System.out.print("Cân nặng TB: ");
                    t.setAverageWeight(Double.parseDouble(sc.nextLine()));
                    break;
            }
        } while (choice != 0);
    }

    // xóa
    public void delete(String id) {
        Team t = findById(id);
        if (t != null) {
            list.remove(t);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tồn tại!");
        }
    }

    // tìm kiếm
    public void search(String key) {
        list.stream()
                .filter(t -> t.getTeamName().toLowerCase().contains(key.toLowerCase()))
                .forEach(Team::displayData);
    }

    // sắp xếp giảm dần
    public void sortDesc() {
        list.sort((a, b) -> Double.compare(b.getAverageWeight(), a.getAverageWeight()));
        System.out.println("Đã sắp xếp!");
    }

    // ứng viên vô địch
    public void findChampion() {
        list.stream()
                .filter(t -> t.getAverageWeight() >= 65)
                .forEach(Team::displayData);
    }
}