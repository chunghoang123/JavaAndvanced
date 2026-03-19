package Bai4;

class Fan implements Observer {
    @Override
    public void update(int temperature) {
        if (temperature < 20) {
            System.out.println("Quạt: Nhiệt độ thấp (" + temperature + "°C), tự động TẮT.");
        } else if (temperature <= 25) {
            System.out.println("Quạt: Nhiệt độ vừa phải (" + temperature + "°C), chạy tốc độ TRUNG BÌNH.");
        } else {
            System.out.println("Quạt: Nhiệt độ cao (" + temperature + "°C), chạy tốc độ MẠNH.");
        }
    }

    public void registerInfo() {
        System.out.println("Quạt: Đã đăng ký nhận thông báo từ cảm biến.");
    }
}
