package org.example.tesco.container;

public class BinarySearch {
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();

        int a[] = {2, 3, 4, 10, 40};
        int n = a.length;
        int x = 10;
        int index = ob.binarySearch(a, 0, n - 1, x);
        System.out.println(index);
    }

    private int binarySearch(int[] a, int start, int end, int x) {
       /* if (end >= start) {
            int mid = start + (end - start) / 2;
            if (a[mid] == x) {
                return mid;
            }
            if (x < a[mid]) {
                binarySearch(a, start, mid - 1, x);
            }else{
                return binarySearch(a, mid + 1, end, x);
            }
        }
        return -1;*/
        while(end>=start){
            int mid = (start+end)/2;
            if(a[mid]==x)
                return mid;
            if(a[mid]>x)
            {
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}