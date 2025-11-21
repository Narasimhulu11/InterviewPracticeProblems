package org.example.tesco.container;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostOccuringEle {
    public static void main(String args[]) {
        int arr[] = {40, 50, 30, 40, 50, 30, 30};
        int n = arr.length;
        int k = Arrays.stream(arr).mapToObj(x->(int)x).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getKey();
     /*   Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i) + 1);
        }
        int ele =map.entrySet()
                        .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).findFirst().get().getKey();
*/
        System.out.println(k);
    }
}
