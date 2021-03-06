package 单周赛.第239周赛;

/**
 @author fujiangnan
 @create 2021-05-02-11-58
 @desc 5747. 将字符串拆分为递减的连续值
 给你一个仅由数字组成的字符串 s 。

 请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。

 例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
 另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，因为对应数值分别是 [0,1]、[0,1] 和 [0,0,1] ，都不满足按降序排列的要求。
 如果可以按要求拆分 s ，返回 true ；否则，返回 false 。

 子字符串 是字符串中的一个连续字符序列。

 示例 1：

 输入：s = "1234"
 输出：false
 解释：不存在拆分 s 的可行方法。
 示例 2：

 输入：s = "050043"
 输出：true
 解释：s 可以拆分为 ["05", "004", "3"] ，对应数值为 [5,4,3] 。
 满足按降序排列，且相邻值相差 1 。
 示例 3：

 输入：s = "9080701"
 输出：false
 解释：不存在拆分 s 的可行方法。
 示例 4：

 输入：s = "10009998"
 输出：true
 解释：s 可以拆分为 ["100", "099", "98"] ，对应数值为 [100,99,98] 。
 满足按降序排列，且相邻值相差 1 。
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "0001";
        System.out.println(splitString(s));
    }
    public static boolean splitString(String s) {
        long cur = 0;
        // 在主循环里面遍历所有情况
        for (int i = 0; i < s.length()-1; i++) {
            cur = cur * 10 + s.charAt(i) -'0';
            // 递归判断所有情况
            if (dfs(s.substring(i+1), cur)) {
                return true;
            }
        }
        return false;
    }
    public static boolean dfs(String s, long max) {
        // 先进行拆分为两个数的判断
        long cur = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = cur * 10 + s.charAt(i) - '0';
        }
        if (cur == max - 1) {
            return true;
        }
        // 拆分大于两个数的判断
        cur = 0;
        for (int i = 0; i <s.length(); i++) {
            cur = cur * 10 + s.charAt(i) - '0';
            if (cur < max - 1) {
                continue;
            } else if (cur > max - 1) {
                break;
            }
            // 如果cur == max-1,递归进行判断
            if (dfs(s.substring(i+1), cur)){
                return true;
            }
        }
        return false;
    }
}
