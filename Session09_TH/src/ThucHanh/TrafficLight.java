package ThucHanh;

import java.util.concurrent.CopyOnWriteArrayList;

class TrafficLight {
    private final Config cfg;
    private final Monitor monitor;

    private volatile TrafficLightState state = new GreenState();
    private final CopyOnWriteArrayList<TrafficLightListener> listeners = new CopyOnWriteArrayList<>();

    TrafficLight(Config cfg, Monitor monitor) {
        this.cfg = cfg;
        this.monitor = monitor;
    }

    TrafficLightState getState() {
        return state;
    }

    void addListener(TrafficLightListener l) {
        listeners.addIfAbsent(l);
    }

    void removeListener(TrafficLightListener l) {
        listeners.remove(l);
    }

    long currentDurationMs() {
        return state.durationMs(cfg);
    }

    void advance() {
        TrafficLightState old = this.state;
        this.state = old.next();

        monitor.log("Đèn giao thông chuyển trạng thái: " + old.name() + " -> " + this.state.name());

        for (TrafficLightListener l : listeners) {
            try {
                l.onLightChanged(this.state.name());
            } catch (Exception ignored) {
            }
        }
    }
}
