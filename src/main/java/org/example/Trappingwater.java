package org.example;

public class Trappingwater {
    public static void main(String args[]) {
        int arr[] =  {2, 1, 5, 3, 1, 0, 4};
        int n = arr.length;

       /* int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }*/
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        left[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            left[i]=Math.max(left[i-1],arr[i]);
        }
        right[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],arr[i]);
        }
        int waterTrapped=0;
        for(int i=0;i<arr.length;i++){
            waterTrapped += Math.min(left[i], right[i]) - arr[i];
        }
        System.out.println("max" + waterTrapped);
    }
}
