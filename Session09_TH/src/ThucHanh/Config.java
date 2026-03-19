package ThucHanh;

class Config {
    // Giới hạn tổng số phương tiện được sinh ra
    final int MAX_VEHICLES = 10;

    // Thời lượng mô phỏng (vẫn chạy đủ thời lượng, nhưng sau khi đủ 10 xe thì không sinh thêm)
    final long SIMULATION_DURATION_MS = 25_000;
    final int VEHICLE_POOL_SIZE = 32;

    // Sinh xe theo chu kỳ
    final long SPAWN_EVERY_MS = 450;
    final int SPAWN_BATCH_MIN = 1;
    final int SPAWN_BATCH_MAX = 3;

    // Thời gian tiến đến vạch dừng / thời gian băng qua giao lộ
    final long APPROACH_MIN_MS = 250;
    final long APPROACH_MAX_MS = 1200;
    final long CROSSING_MIN_MS = 400;
    final long CROSSING_MAX_MS = 1100;

    // Chu kỳ đèn giao thông
    final long GREEN_MS = 3500;
    final long YELLOW_MS = 900;
    final long RED_MS = 2500;

    // Sức chứa tối đa trong giao lộ (Critical Section)
    final int INTERSECTION_CAPACITY = 2;

    // Ngưỡng phát hiện kẹt xe theo từng hướng
    final int MAX_QUEUE_PER_DIRECTION = 12;

    // Seed random (null = random thật)
    final Long RANDOM_SEED = 42L;
}
