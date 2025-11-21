package org.example;

import java.util.HashSet;

public class TripletSum {
    public static void main(String args[]){
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int target = 13;
        if (hasTripletSum(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }

    private static boolean hasTripletSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        int sum=0;
        for(int i=0;i<arr.length-2;i++){
            for(int j=i+1;j<arr.length;j++){
                sum = arr[i] + arr[j];
                if(set.contains(target-sum)){
                    System.out.println(arr[i]+" "+arr[j]+" "+ (target-sum));
                    return true;
                }
            }
            set.add(arr[i]);
        }
        return false;
    }
}
