package 腾讯微保;
import java.util.*;
/**
 @author fujiangnan
 @create 2021-04-10-20-11
 @desc ...
 */
public class Solution1 {
    public static void main(String[] args) {
        String s = "{[]}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
    public static boolean isValid (String s) {
        boolean ans = false;
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()||stack.pop() != ')') {
                    return false;
                }
            }
            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.pop() != ']') {
                    return false;
                }
            }
            if (s.charAt(i) == '}') {
                if (stack.isEmpty() || stack.pop() != '}') {
                    return false;
                }
            }

        }

        if (stack.isEmpty()) {
            return true;
        }
        return ans;
    }
}
