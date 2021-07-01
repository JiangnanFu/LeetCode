package 单周赛.第234周赛;

import java.util.HashSet;

/**
 @author fujiangnan
 @create 2021-03-28-10-32
 @desc 5713. 字符串中不同整数的数目（AC）
 给你一个字符串 word ，该字符串由数字和小写英文字母组成。

 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。

 返回对 word 完成替换后形成的 不同 整数的数目。

 如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
 */
public class num1 {
    public static void main(String[] args) {
        String word = "a123bc34d8ef34a034";
        int ans = numDifferentIntegers(word);
        System.out.println(ans);
    }
    public static int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();

        for (int i=0; i<word.length(); ++i){
            StringBuffer buffer = new StringBuffer();
            while (i<word.length() && word.charAt(i) <='9' && word.charAt(i) >='0') {
                buffer.append(word.charAt(i));
                ++i;
            }
            if (buffer.length() > 0) {
                int k = 0;
                while (k < buffer.length() && buffer.charAt(k) == '0') {
                    ++k;
                }
                set.add(buffer.toString().substring(k,buffer.length()));
            }
        }
        return set.size();
    }
}
