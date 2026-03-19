package ThucHanh;

interface TrafficLightState {
    String name();

    long durationMs(Config cfg);

    TrafficLightState next();

    boolean isGoAllowed(Vehicle v);
}
