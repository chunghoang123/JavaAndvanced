package Bai5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        users.add(new User("alexander", "a@gmail.com", "ACTIVE"));
        users.add(new User("bob", "b@gmail.com", "INACTIVE"));
        users.add(new User("charlotte", "c@gmail.com", "ACTIVE"));
        users.add(new User("Benjamin", "d@gmail.com", "ACTIVE"));
        users.add(new User("tom", "e@gmail.com", "ACTIVE"));

        users.stream()
                .sorted(Comparator.comparingInt((User u) -> u.username().length()).reversed())
                .limit(3)
                .forEach(u -> System.out.println(u.username()));
    }
}