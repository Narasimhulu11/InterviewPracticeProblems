package interviews.java8.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class ProducerConsumerBasicTest{

    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer(5);
        System.out.println("Buffer capacity: " + buffer.getMaxSize());
        Thread producer1 = new Thread(new Producer(buffer, "P1"), "P1");
        Thread producer2 = new Thread(new Producer(buffer, "P2"), "P2");
//        Thread producer3 = new Thread(new Producer(buffer, "P3"), "P3");
//        Thread producer4 = new Thread(new Producer(buffer, "P4"), "P4");
//        Thread producer5 = new Thread(new Producer(buffer, "P5"), "P5");
//        Thread producer6 = new Thread(new Producer(buffer, "P6"), "P6");
        Thread consumer1 = new Thread(new Consumer(buffer, "C1"), "C1");
        Thread consumer2 = new Thread(new Consumer(buffer, "C2"), "C2");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted.");
        } finally {
            producer1.interrupt();
            producer2.interrupt();
            consumer1.interrupt();
            consumer2.interrupt();
        }
    }
}


class SharedBuffer {
    private final Queue<Integer> queue;
    private final int maxSize;


    public SharedBuffer(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public synchronized void put(int item) throws InterruptedException {
        while (queue.size() == maxSize) {
            System.out.println(Thread.currentThread().getName() + ": Buffer is FULL. Waiting for consumers...");
            this.wait();
        }
        queue.add(item);
        System.out.println(Thread.currentThread().getName() + ": Produced: " + item + ". Current buffer size: " + queue.size());

        this.notifyAll();
    }


    public synchronized int take() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + ": Buffer is EMPTY. Waiting for producers...");
            this.wait();
        }

        int item = queue.remove();
        System.out.println(Thread.currentThread().getName() + ": Consumed: " + item + ". Current buffer size: " + queue.size());
        this.notifyAll();
        return item;
    }
}

class Producer implements Runnable {
    private final SharedBuffer buffer;
    private final String name;
    private final Random random;

    public Producer(SharedBuffer buffer, String name) {
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
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted. Stopping production.");
        }
    }
}

class Consumer implements Runnable {
    private final SharedBuffer buffer;
    private final String name;
    private final Random random;

    public Consumer(SharedBuffer buffer, String name) {
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
                Thread.sleep(random.nextInt(700));
            }
        } catch (InterruptedException e) {
            System.out.println(name + ": Interrupted. Stopping consumption.");
        }
    }
}

