package Bai1;

// --- Các Factory cụ thể (Concrete Factories) ---
class LightFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("LightFactory: Đã tạo đèn mới.");
        return new Light();
    }
}
