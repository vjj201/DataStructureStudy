package org.example.houng_yang;

import java.util.Stack;

/**
 * @author YuCheng
 * @date 2021/12/16 - 下午 08:46
 */
public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String str) {
        if (str.length() == 0) {
            return true;
        }

        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if ('(' == ch || '{' == ch || '[' == ch) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char temp = stack.pop();
                    if (ch == ')') {
                        if (temp != '(') {
                            return false;
                        }

                    } else if (ch == '}') {
                        if (temp != '{') {
                            return false;
                        }

                    } else if (ch == ']') {
                        if (temp != '[') {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
