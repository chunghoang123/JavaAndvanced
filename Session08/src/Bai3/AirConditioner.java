package Bai3;

class AirConditioner {
    private int temperature = 25; // Nhiệt độ mặc định

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temperature);
    }

    public int getTemperature() {
        return temperature;
    }
}
