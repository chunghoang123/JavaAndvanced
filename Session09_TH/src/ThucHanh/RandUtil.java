package ThucHanh;

import java.util.List;
import java.util.Random;

class RandUtil {
    private final Random r;

    RandUtil(Long seed) {
        this.r = (seed == null) ? new Random() : new Random(seed);
    }

    int nextInt(int bound) {
        return r.nextInt(bound);
    }

    int betweenInt(int minInclusive, int maxInclusive) {
        if (maxInclusive <= minInclusive) return minInclusive;
        return minInclusive + r.nextInt(maxInclusive - minInclusive + 1);
    }

    long betweenLong(long minInclusive, long maxInclusive) {
        if (maxInclusive <= minInclusive) return minInclusive;
        long d = maxInclusive - minInclusive + 1;
        long v = (long) (r.nextDouble() * d);
        return minInclusive + v;
    }

    <T> T pickWeighted(List<T> items, List<Integer> weights) {
        int sum = 0;
        for (int w : weights) sum += w;
        int x = r.nextInt(sum);
        int acc = 0;
        for (int i = 0; i < items.size(); i++) {
            acc += weights.get(i);
            if (x < acc) return items.get(i);
        }
        return items.get(items.size() - 1);
    }
}
