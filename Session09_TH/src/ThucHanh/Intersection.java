package ThucHanh;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class Intersection {
    private final Config cfg;
    private final Monitor monitor;

    private final Semaphore capacity;
    private final AtomicBoolean emergencyInProgress = new AtomicBoolean(false);
    private final AtomicInteger insideCount = new AtomicInteger(0);

    Intersection(Config cfg, Monitor monitor) {
        this.cfg = cfg;
        this.monitor = monitor;
        this.capacity = new Semaphore(cfg.INTERSECTION_CAPACITY, true);
    }

    boolean isEmergencyInProgress() {
        return emergencyInProgress.get();
    }

    void requestEnter(Vehicle v) throws InterruptedException {
        // Xe thường nhường đường khi đang có xe ưu tiên xử lý
        while (!v.isPriority() && emergencyInProgress.get()) {
            Thread.sleep(20);
        }

        // Xe ưu tiên bật cờ ưu tiên để xe khác nhường
        if (v.isPriority()) {
            emergencyInProgress.set(true);
        }

        capacity.acquire();

        int nowInside = insideCount.incrementAndGet();
        if (nowInside > cfg.INTERSECTION_CAPACITY) {
            throw new CollisionException("Vượt sức chứa giao lộ! insideCount=" + nowInside);
        }

        monitor.log(v + " ĐI VÀO giao lộ (inside=" + nowInside + ")");
    }

    void leave(Vehicle v) {
        int nowInside = insideCount.decrementAndGet();
        capacity.release();

        monitor.log(v + " RA KHỎI giao lộ (inside=" + nowInside + ")");

        if (v.isPriority()) {
            emergencyInProgress.set(false);
        }
    }
}
