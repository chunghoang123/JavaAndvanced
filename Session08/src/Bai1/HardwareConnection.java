package Bai1;


class HardwareConnection {
    private static HardwareConnection instance;
    private boolean isConnected = false;

    // Private constructor ngăn khởi tạo từ bên ngoài
    private HardwareConnection() {
    }

    public static synchronized HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
        }
        return instance;
    }

    public void connect() {
        if (!isConnected) {
            System.out.println("HardwareConnection: Đã kết nối phần cứng.");
            isConnected = true;
        }
        // Nếu đã kết nối, không in gì thêm theo yêu cầu
    }
}
