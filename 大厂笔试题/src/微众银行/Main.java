package 微众银行;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-05-13-18-19
 @desc 时间限制： 3000MS
 内存限制： 589824KB
 题目描述：
 现在有n座山从左到右排成一排，每座山有自己的海拔h[i]，Cheems想要通过爬山来征服这几座山峰，当Cheems站在一座山的山巅，向左看没有山的海拔高度高于当前的山的高度，向右看也没有一座山能高于当前这座山，Cheems的征服感就会增加1。求问当Cheems征服了这几座山巅之后获得的征服感为多少。



 输入描述
 第一行包括一个正整数n，表示山峰的数量。

 第二行有n个正整数，其中第i个数代表第i座山顶的海拔h[i]

 1≤h[i]≤100000

 输出描述
 一个整数，表示答案，cheems获得的征服感

 样例输入
 5
 3 2 1 2 3
 样例输出
 2

 提示
 当cheems站在第1座山上时，没有任何一座山峰的高度严格大于h[1]，获得一点征服感。站在第5座山峰上同理，共获得两点征服感。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(v(arr));
    }
    public static int v(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int maxVal = 0;
        for (int i = arr.length - 1; i >=0 ; i--) {
            if (arr[i] >= maxVal) {
                maxVal = arr[i];
                ++count;
            }
        }
        return count;
    }
}
