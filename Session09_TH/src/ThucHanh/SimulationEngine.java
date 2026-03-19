package ThucHanh;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class SimulationEngine {
    // Đếm số xe đã sinh ra để giới hạn đúng MAX_VEHICLES
    private final AtomicInteger spawnedCount = new AtomicInteger(0);
    private final AtomicBoolean loggedSpawnStop = new AtomicBoolean(false);

    private final Config cfg;
    private final Monitor monitor;
    private final StatsService stats;

    private final TrafficLight light;
    private final Intersection intersection;
    private final TrafficEnvironment env;
    private final VehicleFactory factory;

    private final ExecutorService vehiclePool;
    private final ScheduledExecutorService scheduler;

    private final AtomicBoolean running = new AtomicBoolean(false);
    private final RandUtil rand;

    SimulationEngine(Config cfg, Monitor monitor, StatsService stats,
                     TrafficLight light, Intersection intersection, TrafficEnvironment env, VehicleFactory factory) {
        this.cfg = cfg;
        this.monitor = monitor;
        this.stats = stats;
        this.light = light;
        this.intersection = intersection;
        this.env = env;
        this.factory = factory;

        this.vehiclePool = Executors.newFixedThreadPool(cfg.VEHICLE_POOL_SIZE);
        this.scheduler = Executors.newScheduledThreadPool(2);
        this.rand = new RandUtil(cfg.RANDOM_SEED);
    }

    void start() {
        if (!running.compareAndSet(false, true)) return;

        monitor.log("BẮT ĐẦU MÔ PHỎNG");
        monitor.log("Sức chứa giao lộ K = " + cfg.INTERSECTION_CAPACITY);
        monitor.log("Giới hạn số phương tiện sinh ra = " + cfg.MAX_VEHICLES);

        // Lập lịch chuyển đèn
        scheduleNextLightAdvance(0);

        // Lập lịch sinh xe
        scheduler.scheduleAtFixedRate(() -> {
            if (!running.get()) return;

            int remaining = cfg.MAX_VEHICLES - spawnedCount.get();
            if (remaining <= 0) {
                if (loggedSpawnStop.compareAndSet(false, true)) {
                    monitor.log("Đã sinh đủ " + cfg.MAX_VEHICLES + " phương tiện -> dừng sinh thêm.");
                }
                return;
            }

            int batch = rand.betweenInt(cfg.SPAWN_BATCH_MIN, cfg.SPAWN_BATCH_MAX);
            batch = Math.min(batch, remaining);

            for (int i = 0; i < batch; i++) {
                Vehicle v = factory.createRandomVehicle(light, intersection, env, stats, monitor);
                try {
                    env.enqueue(v);
                    vehiclePool.submit(v);
                    spawnedCount.incrementAndGet();
                } catch (TrafficJamException jam) {
                    stats.recordJam(v.direction);
                    monitor.log("!!! TrafficJamException: " + jam.getMessage());
                } catch (RejectedExecutionException ignored) {
                    // đang dừng
                }
            }

        }, 0, cfg.SPAWN_EVERY_MS, TimeUnit.MILLISECONDS);
    }

    private void scheduleNextLightAdvance(long initialDelayMs) {
        scheduler.schedule(() -> {
            if (!running.get()) return;
            light.advance();
            scheduleNextLightAdvance(light.currentDurationMs());
        }, initialDelayMs, TimeUnit.MILLISECONDS);
    }

    void stop() throws InterruptedException {
        if (!running.compareAndSet(true, false)) return;

        monitor.log("ĐANG DỪNG MÔ PHỎNG...");
        scheduler.shutdownNow();
        vehiclePool.shutdownNow();

        vehiclePool.awaitTermination(2, TimeUnit.SECONDS);
        scheduler.awaitTermination(2, TimeUnit.SECONDS);

        monitor.log("ĐÃ DỪNG MÔ PHỎNG");
    }
}
