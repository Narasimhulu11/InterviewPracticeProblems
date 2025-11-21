package interviews.das;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
//        printFibonoci(10);
        String s="multiple words    in a string multple words again.";
        String str[]= s.replaceAll("  "," ").split("[/s]");
//       String result= Stream.of(s.split(" ")).sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
//       System.out.println(result);
        StringBuilder newString= new StringBuilder();
       for (int j=str.length-1;j>=0;j--){
           newString.append(str[j]+" ");
       }
       System.out.println(newString);


    }
    static void printFibonoci(int num){

        if(num<2){
            return;//exception
        }
        int i=0;int j=1;

        System.out.println(i+ " "+j);
        int k=2;
        while(k<num){
            int temp=j;
            j=i+j;
            i=temp;
            System.out.println(j);
            k++;
        }
    }
}
