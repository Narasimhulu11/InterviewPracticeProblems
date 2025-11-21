package org.example.tesco.container;

import java.util.PriorityQueue;

public class KthLargestArray {
    public static void main(String args[]){
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k=3;
        // finding kth largest ele using min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            priorityQueue.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(priorityQueue.peek()<arr[i]){
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        System.out.print(priorityQueue.peek());
        System.out.println();
       // priorityQueue.stream().forEach(x->System.out.print(x+" "));
        //finding kth smallest ele using max heap
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>((a,b)->(b-a));
        for(int i:arr){
            priorityQueue1.add(i);
            if(priorityQueue1.size()>k){
                priorityQueue1.poll();
            }
        }
        System.out.print(priorityQueue1.peek());
        System.out.println();
    }
}
