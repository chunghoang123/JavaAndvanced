package Bai1;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class Ex1 {
    public static void main(String[] args){
        User u1 = new User("alice", "ADMIN", "alice@mail.com");

        // 1) Kiểm tra User có phải Admin không -> Predicate<User>
        Predicate<User> isAdmin = user -> "ADMIN".equalsIgnoreCase(user.getRole());

        // 2) Chuyển User thành String username -> Function<User, String>
        Function<User, String> toUsername = User::getUserName;

        // 3) In thông tin User ra console -> Consumer<User>
        Consumer<User> printUser = user -> System.out.println("Chi tiet user: " + user);

        // 4) Tạo User mới mặc định -> Supplier<User>
        Supplier<User> defaultUserSupplier = () -> new User("guest", "USER", "guest@mail.com");

        System.out.println("u1 la admin? " + isAdmin.test(u1));
        System.out.println("Username cua u1: " + toUsername.apply(u1));
        printUser.accept(u1);

        User defaultUser = defaultUserSupplier.get();
        System.out.println("User mac dinh: " + defaultUser);
    }

}

