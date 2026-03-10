package Bai4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new User("bob", "bob@yahoo.com", "INACTIVE"));
        users.add(new User("alice", "alice2@gmail.com", "ACTIVE")); // trùng username
        users.add(new User("charlie", "charlie@gmail.com", "ACTIVE"));

        Set<String> seen = new HashSet<>();

        users.stream()
                .filter(user -> seen.add(user.username()))
                .forEach(user ->
                        System.out.println(user.username() + " - " + user.email() + " - " + user.status())
                );
    }
}