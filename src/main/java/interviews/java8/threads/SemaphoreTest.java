package interviews.java8.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class SemaphoreTest {


    private static final int NUMBER_OF_PRINTERS = 3;
    private static final int NUMBER_OF_USERS = 10;

    public static void main(String[] args) {
        System.out.println("Available Printers (Permits): " + NUMBER_OF_PRINTERS);
        System.out.println("Total Users (Threads) wanting to print: " + NUMBER_OF_USERS);

        Semaphore printers = new Semaphore(NUMBER_OF_PRINTERS, true);


        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_USERS);


        for (int i = 0; i < NUMBER_OF_USERS; i++) {
            executor.submit(new User("User-" + (i + 1), printers));
        }


        try {
            Thread.sleep(15000);
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
            System.out.println("\n--- Semaphore Demo Finished ---");
        }
    }
}

class User implements Runnable {
    private final String name;
    private final Semaphore printers;
    private final Random random;

    // Constructor to initialize the user with a name and the shared Semaphore.
    public User(String name, Semaphore printers) {
        this.name = name;
        this.printers = printers;
        this.random = new Random();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name); // Set thread name for clearer output
        try {
            System.out.println(name + ": is trying to acquire a printer.");

            printers.acquire();
            System.out.println(name + ": acquired a printer. Remaining permits: " + printers.availablePermits());
            int printTime = random.nextInt(2000) + 1000; // Print for 1 to 3 seconds
            System.out.println(name + ": is printing document (takes " + printTime + "ms).");
            Thread.sleep(printTime);
            System.out.println(name + ": finished printing.");

        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted while waiting/printing. Exiting.");
            Thread.currentThread().interrupt(); // Restore interrupted status
        } finally {
            printers.release();
            System.out.println(name + ": released the printer. Remaining permits: " + printers.availablePermits());
        }
    }
}

