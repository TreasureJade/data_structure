package stack;

import java.util.Stack;

/**
 * @author hobo
 * @description 栈解决问题方案
 * 问题：括号匹配 给定一个只包括 (),{},[]的字符串，判断是否有效，括号有序
 */
public class StackExample {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            }
            char topChar = stack.pop();
            if (c == ')' && topChar != '(') {
                return false;
            }
            if (c == '}' && topChar != '{') {
                return false;
            }
            if (c == ']' && topChar != '[') {
                return false;
            }

        }
        // 栈为空，遍历完成并且全部匹配
        return stack.isEmpty();
    }

}
