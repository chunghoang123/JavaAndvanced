package Bai5;

class Fan implements Observer {
    public void setSpeed(String speed) {
        System.out.println("Quạt: Chạy tốc độ " + speed);
    }

    @Override
    public void update(int temp) {
        if (temp > 30) {
            System.out.println("Quạt (Auto): Nhiệt độ " + temp + "°C -> Tự động chuyển sang tốc độ MẠNH.");
        } else if (temp < 22) {
            System.out.println("Quạt (Auto): Nhiệt độ " + temp + "°C -> Tự động TẮT để bảo vệ sức khỏe.");
        }
    }
}
