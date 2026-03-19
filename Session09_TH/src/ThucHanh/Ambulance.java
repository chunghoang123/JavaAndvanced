package ThucHanh;

class Ambulance extends PriorityVehicle {
    Ambulance(String id, Direction direction,
              Config cfg, TrafficLight light, Intersection intersection, TrafficEnvironment env,
              StatsService stats, Monitor monitor, RandUtil rand) {
        super(id, VehicleType.AMBULANCE, 120, 10, direction, cfg, light, intersection, env, stats, monitor, rand);
    }
}
