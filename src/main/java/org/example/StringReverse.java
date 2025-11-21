package org.example;

import java.util.HashMap;

public class StringReverse {
public static void main(String args[]){
    String s = "This this is is done by Saket Saket";
    String[] str = s.split(" ");
    StringBuilder temp = new StringBuilder();
  /*  for(int i=str.length()-1;i>=0;i--){
        temp.append(str.charAt(i));
    }*/
    HashMap<String, Integer> map = new HashMap<>();
    for(int i=0;i<str.length;i++){
        if(map.containsKey(str[i]))
            map.put(str[i], map.get(str[i])+1);
        else
            map.put(str[i], 1);
    }
    System.out.println("map: "+map);
}

}
