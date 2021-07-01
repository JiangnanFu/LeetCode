package 俄罗斯套娃信封问题_354;

import java.util.Arrays;

/**
 @author fujiangnan
 @create 2021-05-12-11-25
 @desc 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。

 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

 注意：不允许旋转信封。

 示例 1：

 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 输出：3
 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class Solution {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        int ans = maxEnvelopes(envelopes);
        System.out.println(ans);
    }
    public static int maxEnvelopes(int[][] envelopes) {
        // 第一个维度进行升序排列，第二个维度进行降序排列，只比较第二个维度即可
        Arrays.sort(envelopes, (a, b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        Arrays.fill(dp,1);
        for (int i = 1; i < envelopes.length ; i++) {
            for (int j = 0; j <i; ++j) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                res = Math.max(dp[i],res);
            }

        }
        return res;
    }
}
