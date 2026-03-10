package Bai6;
@FunctionalInterface
interface UserProcessor {
    String process(User u);
}
public class Ex6 {

    public static void main(String[] args) {

        // Method Reference thay cho Lambda
        UserProcessor processor = UserUtils::convertToUpperCase;

        User user = new User("chung");

        String result = processor.process(user);

        System.out.println("UserName: " + result);
    }
}
