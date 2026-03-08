package Bai3;

public class User {
    private int age;

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuoi khong the am!");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
