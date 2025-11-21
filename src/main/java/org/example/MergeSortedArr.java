package org.example;

import java.util.Arrays;

public class MergeSortedArr {
    public static void main(String args[]) {
        int arr1[] = {1, 3, 4, 5}, arr2[] = {2, 4, 6, 8};
        int n1 = arr1.length, n2 = arr2.length;
        int mergeArr[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                mergeArr[k++] = arr1[i];
                i++;
            } else {
                mergeArr[k++] = arr2[j];
                j++;
            }
        }
        while (i < n1) {
            mergeArr[k++] = arr1[i];
            i++;
        }
        while (j < n2) {
            mergeArr[k++] = arr2[j];
            j++;
        }
        Arrays.stream(mergeArr).forEach(x->System.out.print(x+" "));
    }
}
