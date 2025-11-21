package interviews.das;

import java.util.*;
import java.util.stream.Collectors;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String  s = "abcabdefghi";
        System.out.println(getLongestSubstringWithoutRepeatingCharacter(s));
    }


    private static int getLongestSubstringWithoutRepeatingCharacter(String s) {
        Set<Character> characters=new HashSet<>();
        Map<String,Integer> map=new LinkedHashMap<>();
        int i=0,j=0,max=0;
        while(i<s.length()){
            if(!characters.contains(s.charAt(i))){
                characters.add(s.charAt(i));
                max=Math.max(max,characters.size());
                i++;
            }else{
                map.put(characters.stream().map(String::valueOf).collect(Collectors.joining()),max);
                characters.remove(s.charAt(j));
                j++;
            }
        }
        System.out.println(map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get());
        return max;
    }
}
