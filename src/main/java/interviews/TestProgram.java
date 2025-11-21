package interviews;

import java.util.Arrays;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct using streams.
 */
public class TestProgram {
    public static void main(String args[]){
//        System.out.println(getValidInputString("([{}])"));
//        System.out.println(getValidInputString("([{}])"));
//        System.out.println(getValidInputString("([{}])"));
        int[] nums={1,2,3,4,5,6};
        System.out.println(isRepeatedNumbersExists(nums));

    }

    private static boolean isRepeatedNumbersExists(int[] nums) {
        int count=nums.length;
        return Arrays.stream(nums).distinct().count()!=count;

    }

    private static boolean getValidInputString(String s) {
        char[] chars=s.toCharArray();

        Stack<Character> characterStack = new Stack<>();

            for(int i=0;i<chars.length;i++){
                char ch=chars[i];
                if(ch=='{' || ch=='(' || ch=='[' ){
                    characterStack.push(ch);
                }else if(!characterStack.isEmpty() && ((characterStack.peek()=='{' && ch=='}') || (characterStack.peek()=='(' && ch==')') || (characterStack.peek()=='[' && ch==']') )){
                    characterStack.pop();
                }
            }

        return characterStack.isEmpty();
    }
}
