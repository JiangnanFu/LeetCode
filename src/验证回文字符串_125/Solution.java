package 验证回文字符串_125;

import java.util.zip.DeflaterOutputStream;

/**
 @author fujiangnan
 @create 2021-05-12-22-02
 @desc 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false

 */
public class Solution {
    public static void main(String[] args) {
        //String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
    }
    public static boolean isPalindrome(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<s.length(); ++i) {
            if ((s.charAt(i)>='A'&&s.charAt(i) <='Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                if (Character.isUpperCase(s.charAt(i))) {
                    buffer.append(Character.toLowerCase(s.charAt(i)));
                } else {
                    buffer.append(Character.toLowerCase(s.charAt(i)));
                }
            }
        }
        if (buffer.length() == 0 || buffer.length() == 1) {
            return true;
        }
        int i = 0;
        int j = buffer.length()-1;
        while (i < j) {
            if (buffer.charAt(i) == buffer.charAt(j)) {
                ++i;
                --j;
            } else {
                return false;
            }
        }
        return true;
    }
}
