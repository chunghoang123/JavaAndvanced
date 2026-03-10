package Bai1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhap nam sinh cua ban: ");
            String namSinhChuoi = sc.nextLine();

            int namSinh = Integer.parseInt(namSinhChuoi);

            int namHienTai = 2026;
            int tuoi = namHienTai - namSinh;

            System.out.println("Tuoi cua ban la: " + tuoi);
        }

        catch (NumberFormatException e) {
            System.out.println("Loi: Ban phai nhap nam sinh bang so!");
        }

        finally {
            sc.close();
            System.out.println("Thuc hien don dep tai nguyen trong finally...");
        }
    }

}

