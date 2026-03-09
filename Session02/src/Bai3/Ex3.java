package Bai3;

@FunctionalInterface
interface Authenticatable {

    // phương thức trừu tượng
    String getPassword();

    // default method
    default boolean isAuthenticated() {
        return getPassword() != null && !getPassword().isEmpty();
    }

    // static method
    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}

public class Ex3 {
    public static void main(String[] args) {

        // sử dụng lambda vì interface là Functional Interface
        Authenticatable user = () -> "123456";

        System.out.println("Password: " + user.getPassword());
        System.out.println("Authenticated: " + user.isAuthenticated());

        String encrypted = Authenticatable.encrypt(user.getPassword());
        System.out.println("Encrypted: " + encrypted);
    }
}