package Bai6;

public class User {
    private String name;
    private int age;

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am!");
        }
        this.age = age;
    }

    public void printUser() {
        if (name != null) {
            System.out.println("Ten: " + name);
        } else {
            System.out.println("Ten chua duoc cap nhat");
        }

        System.out.println("Tuoi: " + age);
    }
}
