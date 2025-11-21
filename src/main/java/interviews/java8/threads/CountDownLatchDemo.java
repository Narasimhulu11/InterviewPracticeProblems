package interviews.java8.threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class CountDownLatchDemo {

    private static final int NUMBER_OF_TASKS = 3;

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(NUMBER_OF_TASKS);

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_TASKS);
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            executor.submit(new WorkerTask("Worker-" + (i + 1), latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow(); // If tasks don't terminate, forcefully shut down.
                }
            } catch (InterruptedException e) {
                // Handle interruption during graceful shutdown wait.
                System.err.println("Executor shutdown interrupted.");
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
            System.out.println("--- CountDownLatch Demo Finished ---");
        }
    }
}

class WorkerTask implements Runnable {
    private final String name;
    private final CountDownLatch latch;
    private final Random random;

    public WorkerTask(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
        this.random = new Random();
    }

    @Override
    public void run() {

        Thread.currentThread().setName(name);
        try {
            System.out.println(name + ": Starting task.");
            Thread.sleep(random.nextInt(2000) + 500);
            System.out.println(name + ": Task completed.");
        } catch (InterruptedException e) {
            System.out.println(name + ": Task interrupted before completion.");
            Thread.currentThread().interrupt(); // Re-interrupt the thread
        } finally {
            latch.countDown();
            System.out.println(name + ": Latch count decremented. Remaining: " + latch.getCount());
        }
    }
}

