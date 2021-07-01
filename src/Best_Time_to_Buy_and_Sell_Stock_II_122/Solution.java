package Best_Time_to_Buy_and_Sell_Stock_II_122;


/**
 * @author fujiangnan
 * @create 2021-01-04 11:39:35
 * @desc ...
 */
public class Solution {
    public static int maxProfit1(int[] prices){
        //贪心思想，O(n)
        int res = 0;

        for (int i=1; i<prices.length; ++i){
            int temp = prices[i] - prices[i-1];
            if (temp > 0){
                res += temp;
            }
        }
        return res;
    }
    public static int maxProfit2(int[] prices){
        //动态规划，O(n)
        //第一步：定义初始条件
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        int[][]dp = new int[len][len];
        //第二个数字0：表示没有持有股票；1：代表持有股票
        //第一个数字表示第几天
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1; i<prices.length; ++i){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];

    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res1 = maxProfit1(prices);
        int res2 = maxProfit2(prices);
        System.out.println(res1);
        System.out.println(res2);

    }
}
