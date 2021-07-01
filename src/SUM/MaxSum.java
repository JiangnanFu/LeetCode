package SUM;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MaxSum {
    public static int sum(int[] array, int k) {
        //先排序
        Arrays.sort(array);
        //用双指针
        int len = array.length;
        int sum = -1;
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (array[i] + array[j] >= k) {
                j--;
            }
            if (array[i] + array[j] < k) {
                int temp = array[i] + array[j];
                if (temp > sum) {
                    sum = temp;
                }
                i++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[] {34, 23, 1,24,75,33,54,8};
        int m = 60;
        int result = sum(a, m);
        System.out.println(result);
    }
}
