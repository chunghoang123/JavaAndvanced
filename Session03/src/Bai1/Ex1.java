package Bai1;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new User("bob", "bob@gmail.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));

        // in danh sách user
        users.forEach(user ->
                System.out.println(user.username() + " - " + user.email() + " - " + user.status())
        );
    }
}
