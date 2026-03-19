package ra.presentation;

import ra.business.BookBusiness;
import ra.entity.Book;

import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookBusiness business = BookBusiness.getInstance();

        while (true) {
            System.out.println("******** QUẢN LÝ THƯ VIỆN ********");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm sách");
            System.out.println("3. Cập nhật sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm theo tên");
            System.out.println("6. Lọc theo thể loại");
            System.out.println("7. Sắp xếp theo năm giảm dần");
            System.out.println("8. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    business.displayAll();
                    break;

                case 2:
                    while (true) {
                        Book book = new Book();
                        book.inputData(sc);
                        business.addBook(book);

                        System.out.print("Thêm tiếp? (y/n): ");
                        if (!sc.nextLine().equalsIgnoreCase("y")) break;
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID: ");
                    business.updateBook(sc.nextLine(), sc);
                    break;

                case 4:
                    System.out.print("Nhập ID: ");
                    business.deleteBook(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Nhập tên: ");
                    business.searchByTitle(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Nhập thể loại: ");
                    business.filterByCategory(sc.nextLine());
                    break;

                case 7:
                    business.sortByYearDesc();
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}