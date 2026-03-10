package Bai4;

public class User {
    private String userName;

    public User() {
        this.userName = "guest";
    }

    public User(String username) {
        this.userName = username;
    }

    public String getUsername() {
        return userName;
    }
}
