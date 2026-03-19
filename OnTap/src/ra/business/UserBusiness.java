package ra.business;

import ra.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserBusiness {
    private List<User> users = new ArrayList<>();

    // Singleton
    private static final UserBusiness INSTANCE = new UserBusiness();
    private UserBusiness() {}
    public static UserBusiness getInstance() {
        return INSTANCE;
    }

    // 1. Hiển thị
    public void displayAll() {
        if (users.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.println("ID     | Name           | Age   | Role   | Score");
        users.forEach(User::displayData);
    }

    // 2. Thêm
    public void addUser(User user) {
        boolean exists = users.stream()
                .anyMatch(u -> u.getUserId().equals(user.getUserId()));

        if (exists) {
            System.out.println("Mã người dùng đã tồn tại");
        } else {
            users.add(user);
        }
    }

    // Tìm theo ID
    public Optional<User> findById(String id) {
        return users.stream()
                .filter(u -> u.getUserId().equals(id))
                .findFirst();
    }

    // 3. Update
    public void updateUser(String id, Scanner sc) {
        Optional<User> optional = findById(id);

        if (!optional.isPresent()) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
            return;
        }

        User user = optional.get();

        System.out.println("1. Sửa tên");
        System.out.println("2. Sửa tuổi");
        System.out.println("3. Sửa role");
        System.out.println("4. Sửa điểm");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Tên mới: ");
                user.setUserName(sc.nextLine());
                break;
            case 2:
                System.out.print("Tuổi mới: ");
                user.setAge(Integer.parseInt(sc.nextLine()));
                break;
            case 3:
                System.out.print("Role mới: ");
                user.setRole(sc.nextLine());
                break;
            case 4:
                System.out.print("Điểm mới: ");
                user.setScore(Double.parseDouble(sc.nextLine()));
                break;
        }
    }

    // 4. Tìm theo tên
    public void searchByName(String keyword) {
        List<User> result = users.stream()
                .filter(u -> u.getUserName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            result.forEach(User::displayData);
            System.out.println("Tổng: " + result.size());
        }
    }

    // 5. Xóa
    public void deleteUser(String id) {
        int oldSize = users.size();

        users.removeIf(u -> u.getUserId().equals(id));

        if (users.size() == oldSize) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
        }
    }

    // 6. Lọc ADMIN
    public void filterAdmin() {
        List<User> admins = users.stream()
                .filter(u -> u.getRole().equals("ADMIN"))
                .collect(Collectors.toList());

        admins.forEach(User::displayData);
    }

    // 7. Sắp xếp giảm dần theo score
    public void sortByScoreDesc() {
        users = users.stream()
                .sorted((a, b) -> Double.compare(b.getScore(), a.getScore()))
                .collect(Collectors.toList());

        displayAll();
    }
}