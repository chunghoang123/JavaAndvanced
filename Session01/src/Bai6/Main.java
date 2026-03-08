package Bai6;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        User user = new User();

        try {

            System.out.print("Nhap ten nguoi dung: ");
            String name = sc.nextLine();
            user.setName(name);

            System.out.print("Nhap tuoi: ");
            String ageStr = sc.nextLine();

            int age = Integer.parseInt(ageStr);
            user.setAge(age);

            FileService.saveToFile(user);

        }
        catch (NumberFormatException e) {
            Logger.logError("Nhap tuoi khong hop le: " + e.getMessage());
        }
        catch (InvalidAgeException e) {
            Logger.logError(e.getMessage());
        }
        catch (IOException e) {
            Logger.logError("Loi he thong khi ghi file: " + e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("Dong tai nguyen Scanner");
        }

        user.printUser();
    }
}
