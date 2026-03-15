package Bai6;

import java.lang.management.*;

public class DeadlockDetector implements Runnable {

    public void run() {

        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        System.out.println("Đang quét deadlock...");

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] ids = bean.findDeadlockedThreads();

        if (ids != null) {
            System.out.println("Phát hiện deadlock!");
        } else {
            System.out.println("Không phát hiện deadlock.");
        }
    }
}