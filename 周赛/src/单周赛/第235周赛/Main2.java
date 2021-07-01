package 单周赛.第235周赛;

import java.util.Arrays;

/**
 @author fujiangnan
 @create 2021-04-04-10-18
 @desc 5723. 查找用户活跃分钟数

 给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。

 多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。

 指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。 即使一分钟内执行多个操作，也只能按一分钟计数。

 请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。

 返回上面描述的答案数组 answer

 示例1：
 输入：logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
 输出：[0,2,0,0,0]
 解释：
 ID=0 的用户执行操作的分钟分别是：5 、2 和 5 。因此，该用户的用户活跃分钟数为 2（分钟 5 只计数一次）
 ID=1 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
 2 个用户的用户活跃分钟数都是 2 ，answer[2] 为 2 ，其余 answer[j] 的值都是 0

 示例2：
 输入：logs = [[1,1],[2,2],[2,3]], k = 4
 输出：[1,1,0,0]
 解释：
 ID=1 的用户仅在分钟 1 执行单个操作。因此，该用户的用户活跃分钟数为 1
 ID=2 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
 1 个用户的用户活跃分钟数是 1 ，1 个用户的用户活跃分钟数是 2
 因此，answer[1] = 1 ，answer[2] = 1 ，其余的值都是 0
 */
public class Main2 {
    public static void main(String[] args) {
        int[][] logs = new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}};
        int k = 5;
        int[] ans = findingUsersActiveMinutes(logs, k);
        for (int i :
                ans) {
            System.out.println(i);
        }
    }
    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k+1];
        Arrays.sort(logs, (a,b)-> a[0] == b[0] ? (a[1]>b[1] ?1:-1) : (a[0] > b[0]?1:-1));
        int temp = logs[0][0];
        int count = 1;
        int i = 1;
        while (i < logs.length){
            while (i < logs.length && logs[i][0] == temp){
                if (logs[i][1] != logs[i-1][1]) {
                    ++count;
                }
                ++i;
            }
            ans[count] += 1;
            if (i < logs.length) {
                temp = logs[i][0];
                count = 0;
                ++i;
            }

        }
        return ans;
    }
}
