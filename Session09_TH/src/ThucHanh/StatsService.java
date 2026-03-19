package ThucHanh;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

class StatsService {
    private final LongAdder totalPassed = new LongAdder();
    private final LongAdder jamCount = new LongAdder();
    private final ConcurrentHashMap<VehicleType, LongAdder> passedByType = new ConcurrentHashMap<>();

    void recordPass(Vehicle v) {
        totalPassed.increment();
        passedByType.computeIfAbsent(v.type, k -> new LongAdder()).increment();
    }

    void recordJam(Direction dir) {
        jamCount.increment();
    }

    String buildReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tổng số xe qua giao lộ thành công: ").append(totalPassed.sum()).append("\n");
        sb.append("Thống kê theo loại phương tiện:\n");
        for (VehicleType t : VehicleType.values()) {
            long c = passedByType.getOrDefault(t, new LongAdder()).sum();
            sb.append("  - ").append(t).append(": ").append(c).append("\n");
        }
        sb.append("Số lần phát hiện kẹt xe: ").append(jamCount.sum()).append("\n");
        return sb.toString();
    }
}
