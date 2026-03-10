package Bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Ex4 {
    public static void main(String[] args) {

        // danh sách users
        List<User> users = new ArrayList<>();
        users.add(new User("An"));
        users.add(new User("Binh"));
        users.add(new User("Chi"));

        // 1. (user) -> user.getUsername()
        // Method Reference
        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        // 2. (s) -> System.out.println(s)
        // Method Reference
        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        // 3. () -> new User()
        // Constructor Reference
        Supplier<User> createUser = User::new;

        User u = createUser.get();
        System.out.println("User moi: " + u.getUsername());
    }
}
