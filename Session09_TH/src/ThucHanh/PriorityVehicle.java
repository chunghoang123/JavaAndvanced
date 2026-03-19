package ThucHanh;

class PriorityVehicle extends Vehicle {
    PriorityVehicle(String id, VehicleType type, int speed, int priority, Direction direction,
                    Config cfg, TrafficLight light, Intersection intersection, TrafficEnvironment env,
                    StatsService stats, Monitor monitor, RandUtil rand) {
        super(id, type, speed, priority, direction, cfg, light, intersection, env, stats, monitor, rand);
    }

    boolean canOverrideRed() {
        return true;
    }
}
