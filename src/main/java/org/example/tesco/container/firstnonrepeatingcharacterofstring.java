package org.example.tesco.container;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class firstnonrepeatingcharacterofstring {
    public static void main(String args[]){
        String s = "geeksforgeeks";
        int arr[] = {1, 23, 12, 9, 30, 2, 50}, k = 3;
     /*   Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        //char c = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get().getKey();
        char c = s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                        .entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get().getKey();
        System.out.println(c);*/
        int value = Arrays.stream(arr).mapToObj(x->(int)x).sorted(Collections.reverseOrder()).skip(3-1).findFirst().get();
        System.out.println(value);
    }
}
