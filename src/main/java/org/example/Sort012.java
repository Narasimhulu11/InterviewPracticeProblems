package org.example;

import java.util.Arrays;

public class Sort012 {


    public static void main(String args[]){
        Sort012 sort012 = new Sort012();
        int[] arr = {0,0,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0,0,0,0,0,1,1,1,1,};
        int n = arr.length;
        sort012.sortArray(arr,n);
    }

    private void sortArray(int[] a, int n) {
        int low=0,mid=0,high=n-1;
        while(mid <= high){
            if(a[mid]==2)
            {
                //swap a[mid] and a[low]
                if(a[mid]!=a[low]) {
                    int temp = a[mid];
                    a[mid] = a[low];
                    a[low] = temp;
                }
                mid++;
                low++;
            }else if(a[mid]==1){
                mid++;
            }else if(a[mid]==0){
                //swap mid and high
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }
        Arrays.stream(a).forEach(x->System.out.print(x+" "));
    }
}
