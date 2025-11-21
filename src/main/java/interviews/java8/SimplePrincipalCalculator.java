package interviews.java8;

import java.util.Scanner;

public class SimplePrincipalCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double interest= scanner.nextDouble();
        double interestAmount= scanner.nextDouble();
        int time= scanner.nextInt();
        try{
           double principal=(interestAmount*100)/(interest*time);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
