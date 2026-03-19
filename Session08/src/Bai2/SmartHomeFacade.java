package Bai2;


class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner ac;
    private TemperatureSensor sensor;

    public SmartHomeFacade(Light light, Fan fan, AirConditioner ac, TemperatureSensor sensor) {
        this.light = light;
        this.fan = fan;
        this.ac = ac;
        this.sensor = sensor;
    }

    public void leaveHome() {
        System.out.println("--- Chế độ rời nhà ---");
        light.off();
        fan.off();
        ac.off();
    }

    public void sleepMode() {
        System.out.println("--- Chế độ ngủ ---");
        light.off();
        ac.setTemperature(28);
        fan.setLowSpeed();
    }

    public void displayCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.println("Nhiệt độ hiện tại: " + temp + "°C");
    }
}
