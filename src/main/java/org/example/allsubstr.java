package org.example;

public class allsubstr {
    public static void main(String args[]){
        String s="abaaa";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                findAllPalindromeStr(s.substring(i,j+1));
            }
        }
    }

    private static void findAllPalindromeStr(String substring) {
        StringBuilder sb = new StringBuilder();
        for(int i=substring.length()-1;i>=0;i--){
            sb.append(substring.charAt(i));
        }
        if(sb.toString().equals(substring)){
            System.out.println(substring);
        }
    }
}
