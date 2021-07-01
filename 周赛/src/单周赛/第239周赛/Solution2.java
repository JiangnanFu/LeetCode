package 单周赛.第239周赛;

import java.util.Arrays;

/**
 @author fujiangnan
 @create 2021-05-02-10-26
 @desc 5749. 邻位交换的最小次数
 给你一个表示大整数的字符串 num ，和一个整数 k 。

 如果某个整数是 num 中各位数字的一个 排列 且它的 值大于 num ，则称这个整数为 妙数 。可能存在很多妙数，但是只需要关注 值最小 的那些。

 例如，num = "5489355142" ：
 第 1 个最小妙数是 "5489355214"
 第 2 个最小妙数是 "5489355241"
 第 3 个最小妙数是 "5489355412"
 第 4 个最小妙数是 "5489355421"
 返回要得到第 k 个 最小妙数 需要对 num 执行的 相邻位数字交换的最小次数 。

 测试用例是按存在第 k 个最小妙数而生成的。

 示例 1：

 输入：num = "5489355142", k = 4
 输出：2
 解释：第 4 个最小妙数是 "5489355421" ，要想得到这个数字：
 - 交换下标 7 和下标 8 对应的位："5489355142" -> "5489355412"
 - 交换下标 8 和下标 9 对应的位："5489355412" -> "5489355421"

 示例 2：

 输入：num = "11112", k = 4
 输出：4
 解释：第 4 个最小妙数是 "21111" ，要想得到这个数字：
 - 交换下标 3 和下标 4 对应的位："11112" -> "11121"
 - 交换下标 2 和下标 3 对应的位："11121" -> "11211"
 - 交换下标 1 和下标 2 对应的位："11211" -> "12111"
 - 交换下标 0 和下标 1 对应的位："12111" -> "21111"
 */
public class Solution2 {
    public static void main(String[] args) {
        String num = "5489355142";
        int k = 4;
        int ans = getMinSwaps(num,k);
        System.out.println(ans);
    }
    public static int getMinSwaps(String num, int k) {
        int[] begin = new int[num.length()];
        int[] arr = new int[num.length()];
        for (int i=0; i<num.length(); ++i) {
            begin[i] = num.charAt(i) - '0';
            arr[i] = num.charAt(i) - '0';
        }
        for (int i=0; i<k;++i) {
            nextPermutation(arr);
        }
        int result = 0;
        for (int i=0; i< arr.length; ++i) {
            if (arr[i] != begin[i]) {
                int j=i+1;
                while(begin[j] != arr[i]) {++j;}
                while (j != i) {
                    swap(begin, j, j-1);
                    ++result;
                    --j;
                }
            }
        }
        return result;

    }
    public static void nextPermutation(int[] arr) {
        if (arr.length < 2) {return;}
        int i = arr.length-2;
        int j = arr.length-1;
        int k = arr.length-1;
        while (i>=0 && arr[i] >= arr[j]) {
            --i;
            --j;
        }
        if (i >= 0) {
            while (arr[i] >= arr[k]) {
                --k;
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
        Arrays.sort(arr, j, arr.length);
    }
    public static void swap(int[] begin, int i, int j) {
        int temp = begin[i];
        begin[i] = begin[j];
        begin[j] = temp;
    }
}
