package 腾讯微保;
import java.util.*;
/**
 @author fujiangnan
 @create 2021-04-10-20-37
 @desc 一个整数数组里面，除了两个数之外，其他的数字都出现了两次，写一个程序找出这两个数？
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,3,4,5,5};
        int[] ans = getNumsAppearOnceTwo(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    // 位运算的方法
    public static int[] getNumsAppearOnceTwo (int[] arr) {
        int sum = 0;
        int[] res = new int[2];
        // 第一步：计算没有重复的两个数的异或结果
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];
        }
        // 找到异或结果中 ansXor 中用移位的方式找到第一个二进制数中为 1 的位置，
        // 这个很关键，找到这个位置后，说明在该位置上，这两个不同的数中，一个为 0，一个为 1，这个应该可以理解对吧？
        int pos = 0;
        while ((sum&1)!=1) {
            sum = sum >>1;
            ++pos;
        }

        // 分组异或
        int res1 = 0;
        int res2 = 0;
        for (int j = 0; j < arr.length; j++) {
            if (((arr[j] >> pos) &1) == 1) {
                res1 ^= arr[j];
            } else {
                res2 ^= arr[j];
            }
        }
        res[0] = res1;
        res[1] = res2;
        return res;
    }

//    // 排序的方式，只能通过80%
//    public static int[] getNumsAppearOnceTwo (int[] arr) {
//        Arrays.sort(arr);
//        int[] res = new int[2];
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < arr.length-1; i++) {
//            if (arr[i+1] != arr[i]) {
//                list.add(arr[i]);
//            } else {
//                ++i;
//            }
//            if (i== arr.length - 2 && list.size() == 1){
//                list.add(arr[arr.length - 1]);
//            }
//            if (list.size() == 2) {
//                break;
//            }
//        }
//        res[0] = (int) list.get(0);
//        res[1] = (int) list.get(1);
//        return res;
//    }
}
