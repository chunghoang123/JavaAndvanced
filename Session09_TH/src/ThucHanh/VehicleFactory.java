package ThucHanh;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

class VehicleFactory {
    private final Config cfg;
    private final RandUtil rand;
    private final AtomicLong seq = new AtomicLong(0);

    VehicleFactory(Config cfg) {
        this.cfg = cfg;
        this.rand = new RandUtil(cfg.RANDOM_SEED);
    }

    Vehicle createRandomVehicle(TrafficLight light, Intersection intersection, TrafficEnvironment env,
                                StatsService stats, Monitor monitor) {
        long s = seq.incrementAndGet();
        String id = String.format("%04d", s);

        Direction dir = Direction.values()[rand.nextInt(Direction.values().length)];

        List<VehicleType> types = Arrays.asList(
                VehicleType.MOTORBIKE, VehicleType.CAR, VehicleType.TRUCK, VehicleType.AMBULANCE
        );
        List<Integer> weights = Arrays.asList(45, 35, 15, 5);
        VehicleType t = rand.pickWeighted(types, weights);

        int speed;
        switch (t) {
            case MOTORBIKE:
                speed = rand.betweenInt(40, 70);
                break;
            case CAR:
                speed = rand.betweenInt(50, 90);
                break;
            case TRUCK:
                speed = rand.betweenInt(35, 60);
                break;
            case AMBULANCE:
                speed = rand.betweenInt(100, 140);
                break;
            default:
                speed = 60;
        }

        // Tạo random riêng cho từng xe để tránh các xe có timing giống nhau hoàn toàn
        long vehicleSeed = (cfg.RANDOM_SEED == null) ? System.nanoTime() : (cfg.RANDOM_SEED + s * 9973);
        RandUtil vehicleRand = new RandUtil(vehicleSeed);

        if (t == VehicleType.AMBULANCE) {
            return new Ambulance(id, dir, cfg, light, intersection, env, stats, monitor, vehicleRand);
        }
        return new StandardVehicle(id, t, speed, dir, cfg, light, intersection, env, stats, monitor, vehicleRand);
    }
}
