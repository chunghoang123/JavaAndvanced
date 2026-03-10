package Bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User user = new User();

        try {
            System.out.print("Nhap tuoi: ");
            int age = sc.nextInt();

            user.setAge(age);

            System.out.println("Tuoi cua user: " + user.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
