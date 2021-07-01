package 网易互娱笔试题;

import java.util.Deque;
import java.util.LinkedList;

/**
 @author fujiangnan
 @create 2021-04-18-16-35
 @desc ...
 */
public class Solution1 {
    public static void main(String[] args) {
        String s = "({}])";
        int len = s.length();
        int ans = getMatchBracketsNum(s, len);
        System.out.println(ans);

    }
    public static int getMatchBracketsNum (String inString, int inStringNum) {
        if (inStringNum == 0) {
            return 0;
        }
        if (inStringNum % 2 == 1) {
            return -1;
        }
        int res = 0;
        Deque<Character> stack = new LinkedList<>();
        int i=0;
        while (i<inStringNum) {
            if (inString.charAt(i) == '(') {
                stack.push(')');
            }
            if (inString.charAt(i) == '[') {
                stack.push(']');
            }
            if (inString.charAt(i) == '{') {
                stack.push('}');
            }
            if (inString.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    if (stack.pop() == ')') {
                        res += 1;
                    } else {
                        return - 1;
                    }
                } else {
                    return -1;
                }
            }
            if (inString.charAt(i) == ']') {
                if (!stack.isEmpty()) {
                    if (stack.pop() == ']') {
                        res += 2;
                    } else {
                        return - 1;
                    }
                } else {
                    return -1;
                }
            }
            if (inString.charAt(i) == '}') {
                if (!stack.isEmpty()) {
                    if (stack.pop() == '}') {
                        res += 3;
                    } else {
                        return - 1;
                    }
                } else {
                    return -1;
                }
            }
            ++i;
        }
        return res;
    }
}
