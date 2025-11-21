package org.example;

import java.util.HashMap;

public class LenOfLogSubArr {
    public static void main(String args[]){
        int[] arr = {-5, 8, -14, 2, 4, 12};
        int k = -5;
        System.out.println(longestSubarray(arr, k));
    }

    private static int longestSubarray(int[] arr, int k) {
        int sum = 0, start=0,end=0;
        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
          sum = sum + arr[i];
          if(k-sum==0){
             // start = i+1;
              //end=i;
            //  break;
              max=i+1;
          }
          if(map.containsKey(k-sum)){
             // start = map.get(k-sum)+1;
              //end=i;
              max = Math.max(max,i-map.get(k-sum));
          }
          map.put(sum,i);
        }
        System.out.println("Sum found between indexes "
                + start + " to " + end);
        return max;
    }
}
