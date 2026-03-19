package ThucHanh;

class StandardVehicle extends Vehicle {
    StandardVehicle(String id, VehicleType type, int speed, Direction direction,
                    Config cfg, TrafficLight light, Intersection intersection, TrafficEnvironment env,
                    StatsService stats, Monitor monitor, RandUtil rand) {
        super(id, type, speed, 0, direction, cfg, light, intersection, env, stats, monitor, rand);
    }
}
