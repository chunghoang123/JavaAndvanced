package ThucHanh;

class YellowState implements TrafficLightState {
    public String name() {
        return "YELLOW";
    }

    public long durationMs(Config cfg) {
        return cfg.YELLOW_MS;
    }

    public TrafficLightState next() {
        return new RedState();
    }

    public boolean isGoAllowed(Vehicle v) {
        return true;
    }
}
