package org.example;

public class RotateArrayByK {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        int k=3;
        arr = rotateArrByKtimes(arr,arr.length, k);
        for(int i:arr){
            System.out.print(i +" ");
        }
    }

    private static int[] rotateArrByKtimes(int[] arr, int length, int k) {
        if(k==0){
            return arr;
        }else{
            int temp = arr[length-1];
            for(int i=length-1;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=temp;
        }
        k--;
        return rotateArrByKtimes(arr,length,k);
    }

    private static int[] rotateArrByK(int[] arr, int n, int k) {
        if(k == 0)
            return arr;
        int ele = arr[n-1];
        for(int i=n-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=ele;
        k--;
        return rotateArrByK(arr,n,k);
    }
}
