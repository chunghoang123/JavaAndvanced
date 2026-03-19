package Bai1;

// --- Các lớp cụ thể (Concrete Products) ---
class Light implements Device {
    @Override
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }

    @Override
    public void turnOff() {
        System.out.println("Đèn: Đã tắt.");
    }
}
