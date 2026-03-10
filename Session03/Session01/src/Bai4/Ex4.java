package Bai4;

import java.io.IOException;

public class Ex4 {
    public static void saveToFile() throws IOException {
        throw new IOException("Loi khi ghi file!");
    }

    public static void processUserData() throws IOException {
        saveToFile();
    }

    public static void main(String[] args) {

        try {
            processUserData();
            System.out.println("Luu du lieu thanh cong");
        }
        catch (IOException e) {
            System.out.println("Da xay ra loi: " + e.getMessage());
        }

        System.out.println("Chuong trinh tiep tuc chay...");
    }
}
