package 百度面试题;

/**
 @author fujiangnan
 @create 2021-04-13-15-26
 @desc ...
 */
public class Solution {
    public static void main(String[] args) {
        String s1 = "ab34c";
        String s2 = "a1bc2";
        String ans = LongestString(s1, s2);
        System.out.println(ans);
    }
    public static String LongestString(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int[][] dp = getDP(ch1, ch2);
        int m = ch1.length-1;
        int n = ch2.length-1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while(index >= 0){
            if(n>0 && dp[m][n] == dp[m][n-1]){
                n--;
            }else if (m>0 && dp[m][n] == dp[m-1][n]) {
                m--;
            } else {
                res[index--] = ch1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);

    }

    public static int[][] getDP(char[] ch1, char[] ch2){
        int[][] dp = new int[ch1.length][ch2.length];
        int m = Integer.MAX_VALUE;
        // 给dp矩阵第一行赋值
        for (int i = 0; i < ch2.length; i++) {
            dp[0][i]=0;
            if (ch1[0] == ch2[i]) {
                dp[0][i]=1;
                m=i;
            }
            if(i>m){
                dp[0][i]=1;
            }
        }
        m = Integer.MAX_VALUE;
        for (int i = 0; i < ch2.length; i++) {
            dp[i][0] = 0;
            if(ch2[0] == ch1[i]){
                dp[i][0] = 1;
                m=i;
            }
            if (i>m){
                dp[i][0] = 1;
            }
        }

        //给矩阵其他的地方赋值
        for (int i = 1; i < ch1.length; i++) {
            for (int j = 1; j < ch2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (ch1[i] == ch2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }
        return dp;
    }
}
