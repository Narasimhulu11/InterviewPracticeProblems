package interviews.java8.threads;

import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierExample {


    private static final int NUMBER_OF_PARTIES = 3;

    public static void main(String[] args) {
      CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_PARTIES, () -> {
            System.out.println("\n*** Barrier Tripped! All " + NUMBER_OF_PARTIES + " parties have arrived. ***");
        });
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_PARTIES);
        for (int i = 0; i < NUMBER_OF_PARTIES; i++) {
            executor.submit(new Worker("Worker-" + (i + 1), barrier));
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted during execution.");
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.err.println("Executor did not terminate gracefully in time. Forcing shutdown.");
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                System.err.println("Executor shutdown interrupted.");
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
            System.out.println("\n--- CyclicBarrier Demo Finished ---");
        }
    }
}


class Worker implements Runnable {
    private final String name;
    private final CyclicBarrier barrier;
    private final Random random;

    public Worker(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
        this.random = new Random();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name); // Set thread name for clearer output
        try {
            performWork("Phase 1: Initial setup");

           System.out.println(name + ": arrived at barrier for Phase 2. Waiting for others...");
            barrier.await();
            performWork("Phase 2: Processing data");

            System.out.println(name + ": arrived at barrier for Phase 3. Waiting for others...");
            barrier.await();
            performWork("Phase 3: Finalizing results");
            System.out.println(name + ": Finished all phases for this cycle. Ready for next cycle if barrier resets.");

        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted. Exiting.");
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            System.err.println(name + ": Barrier was broken. Exiting.");

        }
    }

    private void performWork(String phase) throws InterruptedException {
        int workTime = random.nextInt(1000) + 200;
        System.out.println(name + ": " + phase + " (working for " + workTime + "ms)");
        Thread.sleep(workTime);
    }
}

