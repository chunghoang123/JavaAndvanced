package Bai3.Main;

public class UserProcessor {

    public String processEmail(String email) {

        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }

        String[] parts = email.split("@");

        if(parts.length < 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Email must contain domain");
        }

        return email.toLowerCase();
    }
}