package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ReadInput {
    public static void main(String args[]) throws IOException {
        /*InputStreamReader imputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(imputStreamReader);
        String str= bufferedReader.readLine();
        System.out.println(str);*/
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        int arr[] = {1,9,8,4,2,10,15,3};
int k=3;
         for(int i=0;i<arr.length;i++){
             p.add(arr[i]);
             if(p.size()>k){
                 p.poll();
             }
         }
        System.out.println(p.peek());
        System.out.println();
        Arrays.stream(p.toArray()).forEach(a->System.out.print(a+" "));

        // Printing the top element of PriorityQueue
       // System.out.println(p.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        //System.out.println(p.poll());

        // Printing the top element again
        System.out.println(p.peek());
    }
}
