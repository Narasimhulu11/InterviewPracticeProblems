package org.example;

/*given input string "aabbbba" find index & length of longest uniform substring from a
given input String and add more test cases
input: aabbbba
output : 2,4*/

import java.util.Scanner;

//input: aabbbbabb
// i=0 j=1
// temp
public class LonggestUniformSubStr {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String s = "aabbbbabbbbbb";
       // int i=0, j=1, temp=1;
        int count=1;
        int max = 0;
        int start =0, end =0;
       /* while(j<s.length()){
            if(s.charAt(i)==s.charAt(j))
            {
               temp++;
               j++;
            } else{
                temp=1;
                i=j;
                j=i+1;
            }
            if(temp > max){
                max = temp;
                start = i;
                end =j-1;
            }
        }*/
int i;
        for( i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
               count++;
            }else{
               if(count > max){
                   max = count;
                   start = i - count;
               }
                count =1;
            }
        }
       if(count > max){
           max = count;
           start = i - count;
       }
        System.out.println("longest unfirom substr len "+max + start);
        //System.out.println("indices of longest uniform substring are "+start + " "+end);
    }
}
