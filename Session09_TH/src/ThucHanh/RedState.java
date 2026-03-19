package ThucHanh;

class RedState implements TrafficLightState {
    public String name() {
        return "RED";
    }

    public long durationMs(Config cfg) {
        return cfg.RED_MS;
    }

    public TrafficLightState next() {
        return new GreenState();
    }

    public boolean isGoAllowed(Vehicle v) {
        return v.canOverrideRed();
    }
}
