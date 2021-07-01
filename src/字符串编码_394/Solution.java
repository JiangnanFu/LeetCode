package 字符串编码_394;

import java.util.Deque;
import java.util.LinkedList;

/**
 @author fujiangnan
 @create 2021-04-27-11-04
 @desc 字符串编码
 */
public class Solution {
    public static void main(String[] args) {
        String s = "100[leetcode]";
        String ans = decodeString(s);
        System.out.println(ans);
    }
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int mutil = 0;
        LinkedList<Integer> stack_mutil = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (char c :
                s.toCharArray()) {
            if (c == '[') {
                stack_mutil.addLast(mutil);
                stack_res.addLast(res.toString());
                mutil = 0;
                res = new StringBuilder();
            }
            else if (c == ']') {
                StringBuffer temp = new StringBuffer();
                int count = stack_mutil.removeLast();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + temp);
            }
            else if (c >='0' && c <= '9') {
                mutil = mutil * 10 + Integer.parseInt(c+"");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
