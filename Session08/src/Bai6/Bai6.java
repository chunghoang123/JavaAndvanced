package Bai6;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SalesChannelFactory factory = null;

        System.out.println("HỆ THỐNG BÁN HÀNG ĐA KÊNH");
        System.out.println("1. Website\n2. Mobile App");
        System.out.print("Chọn kênh bán hàng: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            factory = new WebsiteFactory();
            System.out.println("Bạn đã chọn kênh Website");
        } else if (choice.equals("2")) {
            factory = new MobileAppFactory();
            System.out.println("Bạn đã chọn kênh Mobile App");
        }

        if (factory != null) {
            OrderService orderService = new OrderService(factory);

            System.out.print("Nhập tên sản phẩm: ");
            String productName = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine());

            orderService.processOrder(productName, price);
        } else {
            System.out.println("Kênh không hợp lệ!");
        }
    }
}