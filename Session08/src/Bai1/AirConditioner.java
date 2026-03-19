package Bai1;

class AirConditioner implements Device {
    @Override
    public void turnOn() {
        System.out.println("Điều hòa: Đang làm mát.");
    }

    @Override
    public void turnOff() {
        System.out.println("Điều hòa: Đã tắt.");
    }
}
