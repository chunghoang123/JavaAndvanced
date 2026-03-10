package Bai2;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new User("bob", "bob@yahoo.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));

        // lọc email gmail và in username
        users.stream()
                .filter(user -> user.email().endsWith("gmail.com"))
                .forEach(user -> System.out.println(user.username()));
    }
}