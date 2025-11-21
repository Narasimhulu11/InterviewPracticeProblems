package interviews.das;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String r="race a car";
        System.out.println(isValidPalindrom(s));
        System.out.println(isValidPalindrom(r));

    }

    private static boolean isValidPalindrom(String s) {
        String result=s.toLowerCase().replaceAll("[^a-z0-9]","");
        int i=0;
        int j=result.length()-1;
        while (i<j){
            if(result.charAt(i)!=result.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
