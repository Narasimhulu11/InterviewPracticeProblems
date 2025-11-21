package interviews.java8.threads;

import java.util.Random;
import java.util.concurrent.*;


public class ProducerConsumerWithBlockingQueue {

    private static final int BUFFER_CAPACITY = 5;
    private static final int NUM_PRODUCERS = 4;
    private static final int NUM_CONSUMERS = 2;
    private static final int RUN_DURATION_SECONDS = 20;

    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_CAPACITY);
        System.out.println("Buffer capacity: " + BUFFER_CAPACITY);

        ExecutorService producerExecutor = Executors.newFixedThreadPool(NUM_PRODUCERS);
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(NUM_CONSUMERS);

        for (int i = 0; i < NUM_PRODUCERS; i++) {
            producerExecutor.execute(new Producer8(buffer, "Producer-" + (i + 1)));
        }

        for (int i = 0; i < NUM_CONSUMERS; i++) {
            consumerExecutor.execute(new Consumer8(buffer, "Consumer-" + (i + 1)));
        }

        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_DURATION_SECONDS));
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted during sleep.");
            Thread.currentThread().interrupt();
        } finally {
            producerExecutor.shutdown();
            consumerExecutor.shutdown();

            try {
                if (!producerExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.out.println("Producer tasks did not terminate in time. Forcing shutdown.");
                    producerExecutor.shutdownNow();
                }
                if (!consumerExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                    System.out.println("Consumer tasks did not terminate in time. Forcing shutdown.");
                    consumerExecutor.shutdownNow();
                }
            } catch (InterruptedException e) {
                System.err.println("Shutdown interrupted.");
                producerExecutor.shutdownNow();
                consumerExecutor.shutdownNow();
                Thread.currentThread().interrupt();
            }

        }
    }
}

class Producer8 implements Runnable {
    private final BlockingQueue<Integer> buffer;
    private final String name;
    private final Random random;

    public Producer8(BlockingQueue<Integer> buffer, String name) {
        this.buffer = buffer;
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int item = random.nextInt(100);
                buffer.put(item);
                System.out.println(name + ": Produced: " + item + ". Current buffer size: " + buffer.size());
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted. Stopping production.");
        }
    }
}


class Consumer8 implements Runnable {
    private final BlockingQueue<Integer> buffer;
    private final String name;
    private final Random random;

    public Consumer8(BlockingQueue<Integer> buffer, String name) {
        this.buffer = buffer;
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int item = buffer.take();
                System.out.println(name + ": Consumed: " + item + ". Current buffer size: " + buffer.size());
                Thread.sleep(random.nextInt(700));
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted. Stopping consumption.");
        }
    }
}

