package 网易互娱笔试题;

import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-04-18-16-58
 @desc ...
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
//        for (int i = 0; i <len; i++) {
//            System.out.println(arr[i]);
//        }
        int ans = maxPowers(arr);
        System.out.println(ans);
    }
    public static int maxPowers(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        int[][] dp = new int[len+1][len+1];
//        // 初始化
//        for (int i = 1; i <= len; i++) {
//            dp[i][i] = arr[i-1];
//        }
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                if (i == j) {
                    dp[i][j] = arr[i-1];
                } else {
                    if ((j-i) % 2 == 0) {
                        dp[i][j] = dp[i][j-1] + arr[j-1];
                    } else {
                        dp[i][j] = dp[i][j-1] - arr[j-1];
                    }
                }
                if (dp[i][j]  > maxValue) {
                    maxValue = dp[i][j];
                }
            }
        }
        if (maxValue <= 0) {
            return 0;
        }
        return maxValue;
    }

}
