package org.test;
//Queue using arrays
//First in first out
public class Queuee {
    private static final int MAX_SIZE = 4;
    int[] queue = new int[MAX_SIZE];
    int rear = 0,front=0;
    public static void main(String args[]){
        Queuee queuee = new Queuee();
        queuee.push(10);
        queuee.push(20);
        queuee.push(30);
        queuee.push(40);
        queuee.print();
        System.out.println();
        queuee.pop();
        System.out.println();
        queuee.print();
    }

    private int pop() {
        // check for underflow
       // int ele = queue[0];
       /* for(int i=0;i<queue.length-1;i++){
            queue[i] = queue[i+1];
        }*/
        int ele = queue[front];
        front++;
        return ele;
    }

    private void print() {
        for(int i=front;i<rear;i++){
            System.out.print(queue[i]+" ");
        }
    }

    private void push(int ele) {
        if(rear == MAX_SIZE-1){
            System.out.print("Queue Overflow");
        }
        else if(front==rear){
            front=0;
        }
        queue[rear++] = ele;

    }


}
