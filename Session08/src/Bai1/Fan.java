package Bai1;

class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Quạt: Đang quay.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Đã dừng.");
    }
}
