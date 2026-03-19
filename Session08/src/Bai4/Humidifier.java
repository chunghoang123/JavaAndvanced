package Bai4;

class Humidifier implements Observer {
    @Override
    public void update(int temperature) {
        System.out.println("Máy tạo ẩm: Đang điều chỉnh độ ẩm tối ưu cho nhiệt độ " + temperature + "°C.");
    }

    public void registerInfo() {
        System.out.println("Máy tạo ẩm: Đã đăng ký nhận thông báo từ cảm biến.");
    }
}
