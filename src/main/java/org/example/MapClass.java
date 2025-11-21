package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class MapClass {
    // map with key as a
   /* 1, "aruna"
            2, "sidd"
            3, "soumya"
            4, null
            5, null*/

    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("vivek", 100);
        map.put("Rinku", 400);
        map.put("vishal", 600);
        map.put("shankar", 500);
        map.put("shyam", 500);
        map.put("tinku", 300);
        Map<String,Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        System.out.println(sortedMap);


        List<Map.Entry<String,Integer>> map1 =  map.entrySet().stream().collect(Collectors.groupingBy(k->k.getValue())).entrySet()
                .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).skip(1).findFirst().get().getValue();

        System.out.println(map1);


    }
}

