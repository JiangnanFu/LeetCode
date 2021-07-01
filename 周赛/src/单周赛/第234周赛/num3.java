package 单周赛.第234周赛;

import java.util.HashMap;

/**
 @author fujiangnan
 @create 2021-03-28-11-59
 @desc   5715. 还原排列的最少操作步数(未AC)

 给你一个偶数 n，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
 一步操作中，你将创建一个新数组 arr ，对于每个 i ：

 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 然后将 arr 赋值给 perm 。
 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数
 */
public class num3 {
    public static void main(String[] args) {
        int N = 4;
        int ans = reinitializePermutation(N);
        System.out.println(ans);
    }

    public static int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int count = 1;
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            if (j % 2 == 0) {
                arr[j] = perm[j / 2];
            } else {
                arr[j] = perm[n / 2 + (j - 1) / 2];
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < n; k++) {
            map.put(arr[k],k);
        }
        for (int m = 0; m < n; m++) {
            if (m != arr[m]) {
                int pos1 = map.get(m);
                map.put(pos1,arr[m]);
                arr[pos1] = arr[m];
                arr[m] = m;
                ++count;
            }
        }
        return count;
    }
}
