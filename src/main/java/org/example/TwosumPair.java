package org.example;

import java.util.HashSet;
import java.util.Set;

public class TwosumPair {
    public static void main(String args[]) {
        int arr[] = {0, -1, 2, -3, 1}, target = -2;
        //(1, -3)
       /* int i=0,j=0, sum=0;
        while(i<arr.length && j<arr.length){
            j=i+1;
            sum = arr[i]+arr[j];
            if(sum==target){
                System.out.println(arr[i]+" "+arr[j]);
                i++;
                j++;
            }else if(sum < target){
                j++;
                continue;
            }else{
                i++;
                continue;
            }
        }*/
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            int sum = target - arr[i];
            if (!set.contains(sum)) {
                set.add(arr[i]);
            } else {
                System.out.println(arr[i] + " " + sum);

            }

        }
    }

}
