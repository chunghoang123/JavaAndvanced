package ra.business;

import ra.entity.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StudentBusiness {
    private List<Student> students = new ArrayList<>();

    // Singleton
    private static final StudentBusiness INSTANCE = new StudentBusiness();
    private StudentBusiness() {}
    public static StudentBusiness getInstance() {
        return INSTANCE;
    }

    // Hiển thị
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.println("ID     | Name            | Age  | Major          | GPA");
        students.forEach(Student::displayData);
    }

    // Thêm
    public void addStudent(Student s) {
        students.add(s);
    }

    // Tìm theo ID
    public Optional<Student> findById(String id) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst();
    }

    // Update
    public void updateStudent(String id, Scanner sc) {
        Optional<Student> optional = findById(id);

        if (!optional.isPresent()) {
            System.out.println("Không tìm thấy sinh viên!");
            return;
        }

        Student s = optional.get();

        System.out.println("1. Sửa tên");
        System.out.println("2. Sửa tuổi");
        System.out.println("3. Sửa ngành");
        System.out.println("4. Sửa GPA");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Tên mới: ");
                s.setName(sc.nextLine());
                break;
            case 2:
                System.out.print("Tuổi mới: ");
                s.setAge(Integer.parseInt(sc.nextLine()));
                break;
            case 3:
                System.out.print("Ngành mới: ");
                s.setMajor(sc.nextLine());
                break;
            case 4:
                System.out.print("GPA mới: ");
                s.setGpa(Double.parseDouble(sc.nextLine()));
                break;
        }
    }

    // Xóa
    public void deleteStudent(String id) {
        int oldSize = students.size();

        students.removeIf(s -> s.getStudentId().equals(id));

        if (students.size() == oldSize) {
            System.out.println("Không tìm thấy sinh viên!");
        }
    }

    // Tìm theo tên
    public void searchByName(String keyword) {
        List<Student> result = students.stream()
                .filter(s -> s.getName().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            result.forEach(Student::displayData);
            System.out.println("Tổng: " + result.size());
        }
    }

    // Lọc GPA >= 3.0
    public void filterGoodStudents() {
        students.stream()
                .filter(s -> s.getGpa() >= 3.0)
                .forEach(Student::displayData);
    }

    // Sắp xếp GPA giảm dần
    public void sortByGpaDesc() {
        students = students.stream()
                .sorted((a, b) -> Double.compare(b.getGpa(), a.getGpa()))
                .collect(Collectors.toList());

        displayAll();
    }
}