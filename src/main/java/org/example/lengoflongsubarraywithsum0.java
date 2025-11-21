package org.example;

import java.util.HashMap;
import java.util.Map;

public class lengoflongsubarraywithsum0 {
    public static void main(String args[]){
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        //Output: 5
      /* int count=0,max=0;
        for(int i=0;i<arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum = sum+arr[j];
                if (sum == 0)
                    max = Math.max(max, j - i + 1);
            }
        }*/
        Map<Integer,Integer> map = new HashMap<>();
        int max=0,start=0,end=-1,currSum=0,target=0;
        for(int i=0;i<arr.length;i++){
            currSum = currSum +arr[i];
            if(target==currSum){
                start=0;
                end=i;
                max = Math.max(max, end-start+1);
            }
            if(map.containsKey(currSum)){
                start=map.get(currSum)+1;
                end=i;
                max=Math.max(max,end-start+1);
            }else{
                map.put(currSum,i);
            }
        }
        System.out.println(start+":"+end);
        System.out.println(max);
    }
}
