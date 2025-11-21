package org;

import java.util.Arrays;

public class Print0and1WithThread {
    static int[] arr = {1, 0, 1, 0, 0, 0, 1, 1, 1};
    int count = 0;
    static int n = arr.length;

    public synchronized void printOdd() {
        while (count < n) {
            try {
                if (arr[count] == 0) {
                    System.out.println(Thread.currentThread().getName() + " : " + arr[count]);
                    count++;
                    notify();
                } else {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void printEven() {
        while (count < n) {
            try {
                if (arr[count] == 1) {
                    System.out.println(Thread.currentThread().getName() + " : " + arr[count]);
                    count++;
                    notify();
                } else {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        Print0and1WithThread print0and1WithThread = new Print0and1WithThread();
        Thread t1 = new Thread(() -> print0and1WithThread.printOdd());
        Thread t2 = new Thread(() -> print0and1WithThread.printEven());
        t1.start();
        t2.start();
    }
}
