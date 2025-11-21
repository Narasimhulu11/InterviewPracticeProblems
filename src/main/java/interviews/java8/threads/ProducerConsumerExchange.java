package interviews.java8.threads;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ProducerConsumerExchange {



    public static void main(String[] args) {
        Exchanger<Integer> exchanger= new Exchanger<>();
        ExecutorService producerExecutor= Executors.newSingleThreadExecutor();
        ExecutorService consumerExecutor= Executors.newSingleThreadExecutor();
        producerExecutor.submit(new ProducerExchanger(exchanger,"Producer Exchanger"));
        consumerExecutor.submit(new ConsumerExchanger(exchanger,"Consumer Exchanger"));
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(2000));
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

class ProducerExchanger implements Runnable {
    Exchanger<Integer> exchanger= new Exchanger<>();
    private final String name;
    private final Random random;

    public ProducerExchanger(Exchanger<Integer> exchanger, String name) {
        this.exchanger = exchanger;
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int item = random.nextInt(100);
                int produced=exchanger.exchange(item);
                System.out.println(name + ": Produced: " + item );
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted. Stopping production.");
        }
    }
}


class ConsumerExchanger implements Runnable {
    Exchanger<Integer> exchanger= new Exchanger<>();
    private final String name;
    private final Random random;

    public ConsumerExchanger( Exchanger<Integer> exchanger, String name) {
        this.exchanger = exchanger;
        this.name = name;
        this.random = new Random();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int received = exchanger.exchange(random.nextInt(500));
                System.out.println(name + ": Consumed: " + received);
                Thread.sleep(random.nextInt(700));
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted. Stopping consumption.");
        }
    }
}

