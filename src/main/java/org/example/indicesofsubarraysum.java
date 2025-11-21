package org.example;

import java.util.ArrayList;
import java.util.List;
public class indicesofsubarraysum {
    public static void main(String args[]){
       int arr[] = {1, 2, 3, 7, 5}, target = 3;
       List<Integer> indices = findIndicesOfSubArray(arr,target);
       indices.forEach(x->System.out.print(x+" "));
    }

    private static List<Integer> findIndicesOfSubArray(int[] arr, int target) {
      /*  List<Integer> list = new ArrayList<>();
        int start=0, end=0,sum=arr[0];
        for(int i=1;i<arr.length;i++){
            sum = sum + arr[i];
            if (sum >= target){
                end=i;
                while (sum >target && start<i){
                    sum = sum - arr[start];
                    start++;
                }
            }
            if(sum == target){
                list.add(start+1);
                list.add(end+1);
                return list;
            }
        }
        return list;*/
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<=arr.length-target;i++){
            int max=arr[i],start=1;
            while(start<target){
                if(arr[i+start]>max){
                    max=arr[start+i];
                }
                start++;
            }
            list.add(max);
        }
        return list;
    }
}
