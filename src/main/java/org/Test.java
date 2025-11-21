package org;/*
package interviews;
*/
/*input - {0,1,1,0,0,1}

output - {1,1,1,0,0,0}*/


import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String args[]) {
        //  int[] arr = {1,0,0,0,1,1,0,0,0,1,1,1};
        // int i = 0, j = 1;
      /*  while (i<arr.length &&j < arr.length) {
            if(arr[i]==1){
                i++;
            }
            else if (arr[i] < arr[j]) {
                arr[i] = 1;
                arr[j] = 0;
                i++;
            }
            j++;
        }

*/

        //  System.out.println("Try programiz.pro");
     /*   int[] arr = {1,1,1,0,1,1,0,0,0,1,1,1};
                //{0,1,0,1,0,1,0,1,1,0};
        int i=0;
        int n = arr.length;
        int j=n-1;
        while(i<n && j>=0){
            if(arr[i]==1){
                i++;
            }else if(arr[j]==0)
            {
                j--;
            }
            else if(i<j && arr[i]<arr[j]){
                arr[i]=1;
                arr[j]=0;
                i++;
                j--;
            }else{
                break;
            }*/
        //  }
        // Arrays.stream(arr).forEach(x->System.out.print(x+" "));
        String s = "geeksforgeeks";
        char c = s.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
        System.out.println(c + " ");
    }
}


