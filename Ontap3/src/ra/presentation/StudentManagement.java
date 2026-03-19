package ra.presentation;

import ra.business.StudentBusiness;
import ra.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentBusiness business = StudentBusiness.getInstance();

        while (true) {
            System.out.println("******** QUẢN LÝ SINH VIÊN ********");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Lọc sinh viên giỏi (GPA >= 3.0)");
            System.out.println("7. Sắp xếp GPA giảm dần");
            System.out.println("8. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    business.displayAll();
                    break;

                case 2:
                    while (true) {
                        Student s = new Student();
                        s.inputData(sc);
                        business.addStudent(s);

                        System.out.print("Thêm tiếp? (y/n): ");
                        if (!sc.nextLine().equalsIgnoreCase("y")) break;
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID: ");
                    business.updateStudent(sc.nextLine(), sc);
                    break;

                case 4:
                    System.out.print("Nhập ID: ");
                    business.deleteStudent(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Nhập tên: ");
                    business.searchByName(sc.nextLine());
                    break;

                case 6:
                    business.filterGoodStudents();
                    break;

                case 7:
                    business.sortByGpaDesc();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}