package org.example;

public class MinOrMaxSumofSubArrayKSize {
    public static void main(String args[]){
        int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

    private static int maxSum(int[] arr, int n, int k) {
        int max=0;
        for(int i=0;i<=n-k;i++){
            int sum=0,start=0;
            while(start<k){
                sum = sum+arr[i+start];
                start++;
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}
