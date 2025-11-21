package org.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LomgestNonRepSubStr {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestUniqueSubstr(s));
    }

    private static int longestUniqueSubstr(String s) {
      int i=0,max=0;
      Set<Character> set = new LinkedHashSet<>();
      while(i<s.length()){
          if(!set.contains(s.charAt(i))){
              set.add(s.charAt(i));
              i++;
              max=Math.max(max,set.size());
          }else{
             set = new LinkedHashSet<>();
          }
      }
        return max;
    }
}
