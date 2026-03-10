package Bai2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap tong so nguoi dung: ");
        int tongNguoi = sc.nextInt();

        System.out.print("Nhap so nhom muon chia: ");
        int soNhom = sc.nextInt();

        try {
            int moiNhom = tongNguoi / soNhom;
            System.out.println("Moi nhom co: " + moiNhom + " nguoi");
        }
        catch (ArithmeticException e) {
            System.out.println("Khong the chia cho 0!");
        }

        System.out.println("Chuong trinh van tiep tuc chay...");

        sc.close();
    }
}
