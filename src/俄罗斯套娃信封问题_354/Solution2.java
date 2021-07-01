package 俄罗斯套娃信封问题_354;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 @author fujiangnan
 @create 2021-05-12-12-07
 @desc 二分法求解
 */
public class Solution2 {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        int ans = maxEnvelopes(envelopes);
        System.out.println(ans);
    }
    public static int maxEnvelopes(int[][] envelopes) {
        // 第一个维度进行升序排列，第二个维度进行降序排列，只比较第二个维度即可
        Arrays.sort(envelopes, (a, b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        List<Integer> list = new LinkedList<>();
        for (int[] num : envelopes) {
            if (list.size() == 0 || list.get(list.size()-1) < num[1]) {
                list.add(num[1]);
            } else {
                int index = Collections.binarySearch(list, num[1]);
                list.set((index > 0 ? index : -index-1), num[1]);
            }

        }
        return list.size();

    }
}
