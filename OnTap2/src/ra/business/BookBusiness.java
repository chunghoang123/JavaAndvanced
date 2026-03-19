package ra.business;

import ra.entity.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookBusiness {
    private List<Book> books = new ArrayList<>();

    // Singleton
    private static final BookBusiness INSTANCE = new BookBusiness();
    private BookBusiness() {}
    public static BookBusiness getInstance() {
        return INSTANCE;
    }

    // Hiển thị
    public void displayAll() {
        if (books.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        System.out.println("ID     | Title                | Author          | Year  | Category");
        books.forEach(Book::displayData);
    }

    // Thêm
    public void addBook(Book book) {
        books.add(book);
    }

    // Tìm theo ID
    public Optional<Book> findById(String id) {
        return books.stream()
                .filter(b -> b.getBookId().equals(id))
                .findFirst();
    }

    // Update
    public void updateBook(String id, Scanner sc) {
        Optional<Book> optional = findById(id);

        if (!optional.isPresent()) {
            System.out.println("Không tìm thấy sách!");
            return;
        }

        Book book = optional.get();

        System.out.println("1. Sửa tên");
        System.out.println("2. Sửa tác giả");
        System.out.println("3. Sửa năm");
        System.out.println("4. Sửa thể loại");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Tên mới: ");
                book.setTitle(sc.nextLine());
                break;
            case 2:
                System.out.print("Tác giả mới: ");
                book.setAuthor(sc.nextLine());
                break;
            case 3:
                System.out.print("Năm mới: ");
                book.setYear(Integer.parseInt(sc.nextLine()));
                break;
            case 4:
                System.out.print("Thể loại mới: ");
                book.setCategory(sc.nextLine());
                break;
        }
    }

    // Xóa
    public void deleteBook(String id) {
        int oldSize = books.size();

        books.removeIf(b -> b.getBookId().equals(id));

        if (books.size() == oldSize) {
            System.out.println("Không tìm thấy sách!");
        }
    }

    // Tìm theo tên
    public void searchByTitle(String keyword) {
        List<Book> result = books.stream()
                .filter(b -> b.getTitle().toLowerCase()
                        .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            result.forEach(Book::displayData);
            System.out.println("Tổng: " + result.size());
        }
    }

    // Lọc theo thể loại
    public void filterByCategory(String category) {
        books.stream()
                .filter(b -> b.getCategory().equalsIgnoreCase(category))
                .forEach(Book::displayData);
    }

    // Sắp xếp theo năm giảm dần
    public void sortByYearDesc() {
        books = books.stream()
                .sorted((a, b) -> b.getYear() - a.getYear())
                .collect(Collectors.toList());

        displayAll();
    }
}