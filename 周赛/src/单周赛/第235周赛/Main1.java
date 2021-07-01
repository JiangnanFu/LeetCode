package 单周赛.第235周赛;

/**
 @author fujiangnan
 @create 2021-04-04-10-29
 @desc 5722. 截断句子
 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。

 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。

 给你一个句子 s 和一个整数 k ，请你将 s截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
 */
public class Main1 {
    public static void main(String[] args) {
        String s = "chopper is not a tanuki";
        int k = 5;
        String ans = truncateSentence(s,k);
        System.out.println(ans);
    }
    public static String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        int len = arr.length;
        if (k >= len) {
            return s;
        }
        StringBuffer buf = new StringBuffer();
        for (int i=0; i<k; ++i){
            buf.append(arr[i]);
            if (i == k-1) {
                continue;
            }
            buf.append(" ");
        }

        return buf.toString();
    }
}
