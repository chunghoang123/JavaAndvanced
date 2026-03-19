package ra.entity;

import java.util.Scanner;

public class Book {
    private static int counter = 1;

    private String bookId;
    private String title;
    private String author;
    private int year;
    private String category;

    public Book() {
        this.bookId = String.format("B%03d", counter++);
    }

    public Book(String title, String author, int year, String category) {
        this.bookId = String.format("B%03d", counter++);
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
    }

    // Getter
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getCategory() { return category; }

    // Setter
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setYear(int year) { this.year = year; }
    public void setCategory(String category) { this.category = category; }

    // Input
    public void inputData(Scanner sc) {
        System.out.print("Nhập tên sách: ");
        this.title = sc.nextLine();

        System.out.print("Nhập tác giả: ");
        this.author = sc.nextLine();

        while (true) {
            System.out.print("Nhập năm xuất bản: ");
            int year = Integer.parseInt(sc.nextLine());
            if (year > 0) {
                this.year = year;
                break;
            }
            System.out.println("Năm không hợp lệ!");
        }

        System.out.print("Nhập thể loại: ");
        this.category = sc.nextLine();
    }

    // Display
    public void displayData() {
        System.out.printf("%-6s | %-20s | %-15s | %-5d | %-10s\n",
                bookId, title, author, year, category);
    }
}