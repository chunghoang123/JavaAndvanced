package ThucHanh;

import java.util.EnumMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class TrafficEnvironment {
    private final Config cfg;
    private final Monitor monitor;
    private final EnumMap<Direction, BlockingQueue<Vehicle>> queues = new EnumMap<>(Direction.class);

    TrafficEnvironment(Config cfg, Monitor monitor) {
        this.cfg = cfg;
        this.monitor = monitor;
        for (Direction d : Direction.values()) {
            queues.put(d, new LinkedBlockingQueue<>());
        }
    }

    void enqueue(Vehicle v) {
        BlockingQueue<Vehicle> q = queues.get(v.direction);
        int size = q.size();
        if (size >= cfg.MAX_QUEUE_PER_DIRECTION) {
            throw new TrafficJamException("Hàng chờ quá dài tại hướng " + v.direction + " (size=" + size + ")");
        }
        q.offer(v);
        monitor.log(v + " vào hàng chờ tại " + v.direction + " (queueSize=" + q.size() + ")");
    }

    void dequeue(Vehicle v) {
        queues.get(v.direction).remove(v);
    }
}
