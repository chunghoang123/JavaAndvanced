package Bai4;

import java.util.ArrayList;
import java.util.List;


class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        System.out.println("\nCảm biến: Nhiệt độ hiện tại = " + temperature + "°C");
        this.temperature = temperature;
        notifyObservers(); // Tự động thông báo khi có thay đổi
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
