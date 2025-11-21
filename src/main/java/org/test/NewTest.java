package org.test;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NewTest {
    public static void main(String args[]){
        String s = "898989";

        Map<Character, Long> map= s.chars().mapToObj(x->(char)x)
                .collect(Collectors.groupingBy(x->x, Collectors.counting()));
       long value = s.chars().mapToObj(x->(char)x)
                .collect(Collectors.groupingBy(x->x,Collectors.counting()))
                .entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).skip(1).findFirst().get().getValue();
                //forEach(e->System.out.println(e.getValue()));
        System.out.println(map);
    }
}
