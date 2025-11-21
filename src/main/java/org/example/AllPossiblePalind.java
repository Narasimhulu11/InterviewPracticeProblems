package org.example;

import java.io.IOException;

public class AllPossiblePalind {
    public static void main(String args[]) throws IOException {
        String s = "abaaa";int count=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
               // System.out.println(s.substring(i,j+1));
                if(isPalind(s.substring(i,j))){
                    count++;
                }
            }
        }
        System.out.println("count: "+count);
    }

    private static boolean isPalind(String substring) {
        String temp = "";
        for(int i=substring.length()-1;i>=0;i--){
            temp=temp+substring.charAt(i);
        }
        System.out.println(substring +" : " +temp);
        return temp.equals(substring);
    }
}
