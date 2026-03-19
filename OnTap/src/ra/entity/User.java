package ra.entity;

import java.util.Scanner;

public class User {
    private static int counter = 1;

    private String userId;
    private String userName;
    private int age;
    private String role;
    private double score;

    // Constructor không tham số
    public User() {
        this.userId = String.format("U%03d", counter++);
    }

    // Constructor đầy đủ
    public User(String userName, int age, String role, double score) {
        this.userId = String.format("U%03d", counter++);
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    // Getter
    public String getUserId() { return userId; }
    public String getUserName() { return userName; }
    public int getAge() { return age; }
    public String getRole() { return role; }
    public double getScore() { return score; }

    // Setter (không cho set userId)
    public void setUserName(String userName) { this.userName = userName; }
    public void setAge(int age) { this.age = age; }
    public void setRole(String role) { this.role = role; }
    public void setScore(double score) { this.score = score; }

    // Nhập dữ liệu
    public void inputData(Scanner sc) {
        System.out.print("Nhập tên: ");
        this.userName = sc.nextLine();

        // tuổi >= 18
        while (true) {
            System.out.print("Nhập tuổi (>=18): ");
            int age = Integer.parseInt(sc.nextLine());
            if (age >= 18) {
                this.age = age;
                break;
            }
            System.out.println("Tuổi phải >= 18!");
        }

        // role
        while (true) {
            System.out.print("Nhập role (USER/ADMIN): ");
            String role = sc.nextLine().toUpperCase();
            if (role.equals("USER") || role.equals("ADMIN")) {
                this.role = role;
                break;
            }
            System.out.println("Chỉ được USER hoặc ADMIN!");
        }

        // score 0-10
        while (true) {
            System.out.print("Nhập điểm (0-10): ");
            double score = Double.parseDouble(sc.nextLine());
            if (score >= 0 && score <= 10) {
                this.score = score;
                break;
            }
            System.out.println("Điểm phải từ 0-10!");
        }
    }

    // Hiển thị
    public void displayData() {
        System.out.printf("%-6s | %-15s | %-5d | %-6s | %-5.1f\n",
                userId, userName, age, role, score);
    }
}