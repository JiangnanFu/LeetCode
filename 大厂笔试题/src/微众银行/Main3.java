package 微众银行;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-05-13-20-26
 @desc 拼积木
 时间限制： 3000MS
 内存限制： 589824KB
 题目描述：
 小A正在拼积木！她拥有很多块积木，每块上有一个0~9的整数。小A玩腻了普通的积木，想试试有挑战性的，于是她给自己设定了这样的要求：拼出来一行积木，且其上的数字从左到右要能形成一个没有前导零的数字（例如123，5，0则没有前导零，而0123，05，00则含有前导零），并且那个数字要能被30整除。即，假设拼出来的数为X，则需要X%30==0满足。她觉得满足这样要求的数有很多，她只想拼出最大的那一个数。

 请帮帮小A！



 输入描述
 第一行一个整数T，表示数据组数。

 接下来对每组数据，第一行有一个整数n，表示该组数据中小A拥有的积木数量。

 接下来一行n个整数，a1,...,an，表示小A这n块积木上分别写的数字。

 不同组数据之间相互独立。

 1≤T，n≤105，aiϵ{0,1,...,9}，Σn≤105（即T组n之和不超过105）

 输出描述
 对每组数据输出一行无前导零的数字，表示答案。如果无法拼出任何满足要求的数，则输出-1


 样例输入
 3
 5
 1 2 3 3 0
 2
 3 0
 1
 0
 样例输出
 33210
 30
 0
 */

public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            int l = sc.nextInt();
            Integer[] nums = new Integer[l];
            for (int j = 0; j < l; j++) {
                nums[j] = sc.nextInt();
            }
            Arrays.sort(nums, Collections.reverseOrder());
            while (Integer.parseInt(String.valueOf(nums)) % 30 != 0) {
                nextPermutation(nums);
            }
            ans[i] = String.valueOf(nums);
        }

        for (String s :
                ans) {
            System.out.println(s);
        }
    }
    public static void nextPermutation (Integer[] nums) {
        int n = nums.length;
        int min = n-1;
        boolean flag = false;
        for (int i = n - 1; i >0 ; i--) {
            if (nums[i] > nums[i-1]) {
                while (nums[i-1] >= nums[min]) {
                    min--;
                }
                swap(nums, i-1, min);
                reverse(nums,i);
                flag = true;
                break;
            }
        }
        if (flag){
            Arrays.sort(nums);
        }
    }
    public static void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(Integer[] nums, int start) {
        int n = nums.length;
        int end = n-1;
        while (end > start) {
            swap(nums,start,end);
            --end;
            ++start;
        }
    }
}
