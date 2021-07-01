package 网易笔试题;
import java.util.*;

/**
 @author fujiangnan
 @create 2021-04-10-14-00
 @desc
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = new int[]{5,10,10,10,20};
        int res = billsChange(ints);
        System.out.println(res);
    }
    public static int billsChange (int[] bills) {
        int ans = 0;
        int[] coins = new int[2];
        coins[0] = 2;

        for (int i = 0; i <bills.length; i++) {
            if (bills[i] == 5) {
                coins[0] += 1;
                ++ans;
            }
            if (bills[i] == 10) {
                if(coins[0] < 1) {
                    break;
                }
                coins[1] += 1;
                coins[0] -= 1;
                ++ans;

            }
            if (bills[i] == 20){
                if (coins[1] >= 1 && coins[0] >= 1) {
                    coins[1] -= 1;
                    coins[0] -= 1;
                    ++ans;
                    continue;
                } else if (coins[0] >= 3){
                    coins[0] -= 3;
                    ++ans;
                    continue;
                } else {
                    break;
                }

            }
        }

        return ans;
    }

}
