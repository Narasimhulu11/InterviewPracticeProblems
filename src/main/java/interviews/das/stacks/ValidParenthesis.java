package interviews.das.stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s="{}{}{}{[][][]}";
        System.out.println(isValidParenthesis(s));
    }

    private static boolean isValidParenthesis(String s) {
        char ch[]=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(char c: ch) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && ((stack.peek() == '(' && c == ')') || (stack.peek() == '{' && c == '}') || (stack.peek() == '[' && c == ']'))) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
