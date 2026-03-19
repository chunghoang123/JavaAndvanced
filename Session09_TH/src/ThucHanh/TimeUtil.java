package ThucHanh;

class TimeUtil {
    private static final long START_NANO = System.nanoTime();

    static long sinceStartMs() {
        return (System.nanoTime() - START_NANO) / 1_000_000L;
    }

    static String t() {
        long ms = sinceStartMs();

        long totalSeconds = ms / 1000;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        return String.format("[Thời gian: %02d:%02d:%02d]", hours, minutes, seconds);
    }
}
