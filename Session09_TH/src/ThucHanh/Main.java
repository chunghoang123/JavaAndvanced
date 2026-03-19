package ThucHanh;



public class Main {
    public static void main(String[] args) throws Exception {
        Config cfg = new Config();

        Monitor monitor = new Monitor();
        StatsService stats = new StatsService();

        TrafficLight light = new TrafficLight(cfg, monitor);
        Intersection intersection = new Intersection(cfg, monitor);
        TrafficEnvironment env = new TrafficEnvironment(cfg, monitor);
        VehicleFactory factory = new VehicleFactory(cfg);

        SimulationEngine engine = new SimulationEngine(cfg, monitor, stats, light, intersection, env, factory);
        engine.start();

        // Chạy mô phỏng theo thời lượng cấu hình
        Thread.sleep(cfg.SIMULATION_DURATION_MS);
        engine.stop();

        monitor.line("==================================================");
        monitor.line("BÁO CÁO CUỐI CÙNG");
        monitor.line(stats.buildReport());
        monitor.line("==================================================");
    }
}
