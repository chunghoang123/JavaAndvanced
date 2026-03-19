package ra.entity;

import java.util.Scanner;

public class Student {
    private static int counter = 1;

    private String studentId;
    private String name;
    private int age;
    private String major;
    private double gpa;

    // Constructor rỗng
    public Student() {
        this.studentId = String.format("S%03d", counter++);
    }

    // Constructor đầy đủ
    public Student(String name, int age, String major, double gpa) {
        this.studentId = String.format("S%03d", counter++);
        this.name = name;
        this.age = age;
        this.major = major;
        this.gpa = gpa;
    }

    // Getter
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }

    // Setter (không cho set ID)
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setMajor(String major) { this.major = major; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // Input
    public void inputData(Scanner sc) {
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();

        while (true) {
            System.out.print("Nhập tuổi (>=18): ");
            int age = Integer.parseInt(sc.nextLine());
            if (age >= 18) {
                this.age = age;
                break;
            }
            System.out.println("Tuổi phải >= 18!");
        }

        System.out.print("Nhập ngành: ");
        this.major = sc.nextLine();

        while (true) {
            System.out.print("Nhập GPA (0-4): ");
            double gpa = Double.parseDouble(sc.nextLine());
            if (gpa >= 0 && gpa <= 4) {
                this.gpa = gpa;
                break;
            }
            System.out.println("GPA phải từ 0-4!");
        }
    }

    // Display
    public void displayData() {
        System.out.printf("%-6s | %-15s | %-5d | %-15s | %-4.2f\n",
                studentId, name, age, major, gpa);
    }
}