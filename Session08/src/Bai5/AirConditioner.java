package Bai5;

class AirConditioner implements Observer {
    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ set = " + temperature + "°C");
    }

    @Override
    public void update(int temp) {
        if (temp > 30) {
            System.out.println("Điều hòa (Auto): Nhiệt độ phòng quá cao (" + temp + "°C), tăng cường làm mát!");
        }
    }
}
