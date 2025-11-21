package interviews.java8.threads;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final ReentrantLock lock = new ReentrantLock(true);
    private int count = 0;

    public void increment() {
        lock.lock();
        try {
            incrementInternal();
            System.out.println(Thread.currentThread().getName() + ": " + count);
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    private void incrementInternal() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
