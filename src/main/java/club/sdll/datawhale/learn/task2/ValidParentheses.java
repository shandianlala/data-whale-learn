package club.sdll.datawhale.learn.task2;

import java.util.Stack;

/**
 * @author shandianlala@gmail.com
 * @description Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * https://leetcode.com/problems/valid-parentheses/
 * @since 2019-08-06 23:44
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> antiBracket = new Stack<Character>();
        char[] characters = s.toCharArray();
        for (Character c : characters) {
            if (c == '(') {
                antiBracket.push(')');
            } else if (c == '{') {
                antiBracket.push('}');
            } else if (c == '[') {
                antiBracket.push(']');
            } else {
                if (antiBracket.isEmpty() || c != antiBracket.pop()) {
                    return false;
                }
            }
        }
        return antiBracket.isEmpty();
    }

}

