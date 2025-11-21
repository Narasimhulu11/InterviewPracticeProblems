package interviews;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestCommonSubSequence {
    public static void main(String args[]) {
        String text1 = "abc", text2 = "abc";
        String s = "geeksforgeeks";
        s.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new ,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).findFirst().ifPresent(x->System.out.println(x.getKey()));
       /* Set<Character> set = text1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        int count = 0;
        for (Character c : text2.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        System.out.println(count);*/
    }
}
