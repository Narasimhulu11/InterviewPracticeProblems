package interviews.java8.threads;

public class StaticLocksCounter {
    private static int staticCounter = 0;

    public static synchronized void incrementStaticCounter() {
        // This code block is synchronized on MyClass.class
        staticCounter++;
        System.out.println(Thread.currentThread().getName() + " incremented staticCounter to: " + staticCounter);
    }

    public void instanceMethod() {
        // This method is NOT synchronized on MyClass.class
        // It might be synchronized on 'this' if it were an instance synchronized method
        System.out.println(Thread.currentThread().getName() + " called instanceMethod.");
    }

    public static void main(String[] args) {
        StaticLocksCounter staticLocksCounter= new StaticLocksCounter();
        Runnable task=()->{
            incrementStaticCounter();
        };
        Runnable instanceTask=()->{
            staticLocksCounter.instanceMethod();
        };

        Thread t1= new Thread(task,"t1");
        Thread t2= new Thread(task,"t2");
        Thread t3= new Thread(instanceTask,"t3");
        Thread t4= new Thread(instanceTask,"t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}