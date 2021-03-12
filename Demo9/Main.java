package Demo9;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int NUMBER_OF_ITERATIONS = 100;
    private static int räknare = 0;
    private static AtomicInteger atomiskRäknare = new AtomicInteger(0);
    private static Lock lås = new ReentrantLock();
    private static CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_ITERATIONS + 1);

    public static void main(String[] args) {

        ExecutorService service = null;

        try {
            service = Executors.newFixedThreadPool(NUMBER_OF_ITERATIONS);
            //service = Executors.newSingleThreadExecutor();

            for (int i = 0; i < NUMBER_OF_ITERATIONS; i++) {
                service.submit(Main::exempelLock);
            }
            barrier.await();
            exempelSynchronized2(); // TODO CyclicBarrier

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }

    public static void exempelLock() {
        while (true) {
            if (lås.tryLock()) {
                try {
                    System.out.println(++räknare);
                    return;
                } finally {
                    lås.unlock();
                    try {
                        barrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Låset är upptaget");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static synchronized void exempelSynchronized() {
        System.out.println(++räknare);
    }

    public static synchronized void exempelSynchronized2() {
        System.out.println("Färdig");
    }

    public static void exempelAtomic() {
        System.out.println(atomiskRäknare.incrementAndGet());
    }

    public static void exempelRaceCondition() {
        System.out.println(++räknare);
    }
}
