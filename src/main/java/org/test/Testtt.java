package org.test;

/*Given a string s, find the length of the longest substring without duplicate characters.

        Example 1:
Input: s = "abcabcbb"Output: 3Explanation: The answer is "abc", with the length of 3.*/

import java.util.Arrays;

//1,2,3,4
//4,1,2,3
public class Testtt {

    public static void main(String args[]){
        String s = "abcabcdebb";
        int i=0,j=1,max=0,count=1;
        String longStr = null;
        while(i<s.length() && j<s.length()-1){
            if( j<s.length() && (s.charAt(i)!=s.charAt(j))){
                j++;
               count++;
            }else{
                i++;
                count=1;
            }
            if(count > max){
                max = count;
                longStr = s.substring(i,j-1);
            }
        }
        System.out.println("longStr : "+longStr);
        System.out.println("max : "+max);
    }
}
