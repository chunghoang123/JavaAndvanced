package Bai4;

// Giao diện cho nguồn phát tín hiệu (Cảm biến)
interface Subject {
    void attach(Observer o);

    void detach(Observer o);

    void notifyObservers();
}
