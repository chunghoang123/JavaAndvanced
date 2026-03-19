package ThucHanh;

abstract class Vehicle implements Runnable, TrafficLightListener {
    final String id;
    final VehicleType type;
    final int speed;
    final int priority;
    final Direction direction;

    final Config cfg;
    final TrafficLight light;
    final Intersection intersection;
    final TrafficEnvironment env;
    final StatsService stats;
    final Monitor monitor;
    final RandUtil rand;

    private final Object waitLock = new Object();
    private volatile boolean canProceedSignal = false;

    Vehicle(String id, VehicleType type, int speed, int priority, Direction direction,
            Config cfg, TrafficLight light, Intersection intersection, TrafficEnvironment env,
            StatsService stats, Monitor monitor, RandUtil rand) {
        this.id = id;
        this.type = type;
        this.speed = speed;
        this.priority = priority;
        this.direction = direction;
        this.cfg = cfg;
        this.light = light;
        this.intersection = intersection;
        this.env = env;
        this.stats = stats;
        this.monitor = monitor;
        this.rand = rand;
    }

    boolean isPriority() {
        return priority > 0;
    }

    boolean canOverrideRed() {
        return false;
    }

    public void onLightChanged(String newStateName) {
        TrafficLightState st = light.getState();
        if (st.isGoAllowed(this)) {
            synchronized (waitLock) {
                canProceedSignal = true;
                waitLock.notifyAll();
            }
        }
    }

    void waitUntilAllowed() throws InterruptedException {
        if (light.getState().isGoAllowed(this)) return;

        light.addListener(this);
        try {
            synchronized (waitLock) {
                while (!canProceedSignal && !light.getState().isGoAllowed(this)) {
                    waitLock.wait(250);
                }
            }
        } finally {
            light.removeListener(this);
        }
    }

    public final void run() {
        try {
            long approach = rand.betweenLong(cfg.APPROACH_MIN_MS, cfg.APPROACH_MAX_MS);
            Thread.sleep(approach);

            monitor.log(this + " đến vạch dừng (đèn=" + light.getState().name() + ", speed=" + speed + ")");

            if (!isPriority() && intersection.isEmergencyInProgress()) {
                monitor.log(this + " ĐANG NHƯỜNG ĐƯỜNG (xe ưu tiên đang xử lý)");
            }

            if (!light.getState().isGoAllowed(this)) {
                monitor.log(this + " ĐANG CHỜ vì đèn đỏ");
            }

            waitUntilAllowed();

            env.dequeue(this);

            if ("RED".equals(light.getState().name()) && canOverrideRed()) {
                monitor.log(this + " ĐƯỢC PHÉP VƯỢT ĐÈN ĐỎ (xe ưu tiên)");
            }

            intersection.requestEnter(this);

            long crossing = rand.betweenLong(cfg.CROSSING_MIN_MS, cfg.CROSSING_MAX_MS);
            Thread.sleep(crossing);

            intersection.leave(this);
            stats.recordPass(this);

        } catch (CollisionException ce) {
            monitor.log("!!! CollisionException tại " + this + ": " + ce.getMessage());
        } catch (InterruptedException ignored) {
            // Dừng mô phỏng
        } catch (Exception e) {
            monitor.log("!!! Lỗi không xác định tại " + this + ": " + e);
        }
    }

    public String toString() {
        return type + " #" + id + "@" + direction;
    }
}
