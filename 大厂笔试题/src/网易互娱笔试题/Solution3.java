package 网易互娱笔试题;

import java.util.ArrayList;

/**
 @author fujiangnan
 @create 2021-04-18-17-26
 @desc ...
 */
public class Solution3 {
    public static void main(String[] args) {
        long[][] logs = new long[][]{{1,2}, {2,3}, {3,4}};
        long[] tss = new long[]{1,2,3};
        int[][] ans = search_log(logs, tss);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println(ans[i][j]);
            }
        }
    }
    public static int[][] search_log (long[][] logs, long[] tss) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < tss.length; i++) {
            long num = tss[i];
            for (int j = 0; j < logs.length; j++) {
                if (num >= logs[j][0] && num <= logs[j][1]) {
                    temp.add(j);
                }
            }
            list.add(temp);
        }
        int len = list.size();
        int[][] res = new int[len][];
        for (int i = 0; i < len; i++) {
            int l = list.get(i).size();

            int[] tp = new int[l];
            for (int j = 0; j < l; j++) {
                tp[j] = list.get(i).get(j);
            }
            res[i] = tp;
        }
        return res;
    }
}
