/*
package interviews;

import java.util.Stack;

*/
/*{}()[]

        {[]}

        {][}*//*



public class ParanthesisCheck {
    public static void main(String args[]) {
        String s = "{[]}";


        int n =Integer.MIN_VALUE
        boolean isValid = isValidParanthesis(s);
        if (!isValid) {
            System.out.println("not a valid paranthesis");
        } else {
            System.out.println("valid paranthesis");
        }
    }

    private static boolean isValidParanthesis(String s) {
      */
/*  Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '}') {
                if (stack.size() > 0 && stack.peek() == '{') {
                    stack.pop();
                }
            } else if (s.charAt(i) == ']') {
                if (stack.size() > 0 && stack.peek() == '[') {
                    stack.pop();
                }
            } else if (s.charAt(i) == ')') {
                if (stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                }
            }else{
               return false;
            }
        }
        return stack.isEmpty();*//*

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            // Check if the character is an opening bracket
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }
            else {

                // If it's a closing bracket, check if the stack is non-empty
                // and if the top of the stack is a matching opening bracket
                if (!st.empty() &&
                        ((st.peek() == '(' && s.charAt(i) == ')') ||
                                (st.peek() == '{' && s.charAt(i) == '}') ||
                                (st.peek() == '[' && s.charAt(i) == ']'))) {
                    st.pop();
                }
                else {

                    // Unmatched closing bracket
                    return false;
                }
            }
        }

        // If stack is empty, return true (balanced),
        // otherwise false
        return st.empty();
    }
}
*/
