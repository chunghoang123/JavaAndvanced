package ThucHanh;

class GreenState implements TrafficLightState {
    public String name() {
        return "GREEN";
    }

    public long durationMs(Config cfg) {
        return cfg.GREEN_MS;
    }

    public TrafficLightState next() {
        return new YellowState();
    }

    public boolean isGoAllowed(Vehicle v) {
        return true;
    }
}
