package 贝壳笔试;

import java.util.Arrays;

/**
 @author fujiangnan
 @create 2021-08-13-20-24
 @desc 撒农药
 例子：
 n = 4
 m = 6
 [1,2,2,1]
 走到头就返回撒
 */
public class Main {
    public static void main(String[] args) {
        int n = 4;
        int m = 7;
        long[] longs = FarmerNN(n, m);
        for (int i = 0; i < longs.length; i++) {
            System.out.println(longs[i]);
        }
    }
    public static long[] FarmerNN (int n, long m) {
        // write code here
        //发现规律，一个来回消耗2(n-1)
        long[] ans = new long[n];
        long x = m / (2*n-2);
        long y = m % (2*n-2);
        for (int i = 1; i < n-1; i++) {
            ans[i] = 2*x;
        }
        ans[0] = x;
        ans[n-1] = x;
        // 下面处理余数
        int flag = 0;
        int cur = 0;
        while (y>0){
            ans[cur]++;
            --y;
            if (flag == 0){
                cur++;
                if (cur == n){
                    flag = 1;
                }
            }else{
                cur--;
            }

        }
        return ans;
    }

    //// 这个暴力解法超时
    //public static long[] FarmerNN (int n, long m) {
    //    // write code here
    //    long[] res = new long[n];
    //    int i = 0;
    //    while (m > 0){
    //        while (i<n-1 && m>0){
    //            res[i++]++;
    //            --m;
    //        }
    //        while (i>0 && m>0){
    //            res[i--]++;
    //            --m;
    //        }
    //    }
    //
    //
    //    return res;
    //}
}
