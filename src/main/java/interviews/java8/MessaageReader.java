package interviews.java8;

import java.util.Scanner;

public class MessaageReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder= new StringBuilder();
        String input;
        while(true){
            input=scanner.nextLine();
            if (input.equalsIgnoreCase("end")){
                break;
            }else{
                stringBuilder.append(input).append(" ");
            }
        }
        scanner.close();
        System.out.println(stringBuilder.toString());
    }
}
