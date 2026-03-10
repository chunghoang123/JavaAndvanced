package Bai6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex6 {
    public static void main(String[] args) {

        List<Post> posts = new ArrayList<>();

        posts.add(new Post("Java", List.of("java", "backend")));
        posts.add(new Post("Python", List.of("python", "data")));

        List<String> allTags = posts.stream()
                .flatMap(post -> post.tags().stream())
                .collect(Collectors.toList());

        System.out.println(allTags);
    }
}