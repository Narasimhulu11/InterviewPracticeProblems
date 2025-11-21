package org.example;

import java.util.ArrayList;
import java.util.List;

public class PermOfString {
    public static void main(String args[]) {
        String s = "123";
        List<List<Character>> list = new ArrayList<>();
        PermOfString permOfString = new PermOfString();
        permOfString.backTrack(s, new ArrayList<>(), list, 0);
        System.out.println(list.size());
        for (List<Character> str : list) {
            System.out.println();
            str.forEach(x -> System.out.print(x));
        }
    }

    private static void backTrack(String s, ArrayList<Character> tempList, List<List<Character>> list, int start) {
       /* if (tempList.size() == s.length()) {
            list.add(new ArrayList<>(tempList));
            return;
        }*/
       /* if (list.contains((tempList)))
            return;*/
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < s.length(); i++) {
            if (tempList.contains(s.charAt(i))) {
                continue;
            }
            tempList.add(s.charAt(i));
            backTrack(s, tempList, list, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

}
