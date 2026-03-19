package Bai5;

import java.util.ArrayList;
import java.util.List;


class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int currentTemp;

    public void setTemperature(int temp) {
        this.currentTemp = temp;
        System.out.println("\n[Cảm biến]: Nhiệt độ môi trường thay đổi thành " + temp + "°C");
        notifyObservers();
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
        for (Observer o : observers) o.update(currentTemp);
    }
}
