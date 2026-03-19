package Bai2;

// Lớp Adapter để chuyển đổi F sang C
class ThermometerAdapter implements TemperatureSensor {
    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        int fahrenheit = oldThermometer.getTemperatureFahrenheit();
        // Công thức: (F - 32) * 5 / 9
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return Math.round(celsius * 10.0) / 10.0; // Làm tròn 1 chữ số thập phân
    }
}
