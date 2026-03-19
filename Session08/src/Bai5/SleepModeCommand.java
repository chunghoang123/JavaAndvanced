package Bai5;


class SleepModeCommand implements Command {
    private Light light;
    private AirConditioner ac;
    private Fan fan;
    private TemperatureSensor sensor;

    public SleepModeCommand(Light light, AirConditioner ac, Fan fan, TemperatureSensor sensor) {
        this.light = light;
        this.ac = ac;
        this.fan = fan;
        this.sensor = sensor;
    }

    @Override
    public void execute() {
        System.out.println("\n--- KÍCH HOẠT CHẾ ĐỘ NGỦ (MACRO) ---");
        // Bước 1: Điều khiển trực tiếp
        light.off();
        ac.setTemperature(28);
        fan.setSpeed("THẤP");

        // Bước 2: Thiết lập quan sát tự động (Observer)
        sensor.attach(ac);
        sensor.attach(fan);
        System.out.println("Hệ thống: Đã kích hoạt chế độ tự động theo dõi nhiệt độ.");
    }
}
