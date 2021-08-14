package Sort;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * @author fujiangnan
 * @create 2020-12-08 15:47:17
 * @desc 快速排序（双指针交换法）
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 6, 5, 2, 7, 3, 9, 8, 4, 10, 1 };
        quickSort(array, 0, array.length-1);
        System.out.println("快排结果：");
        for (int m : array) {
            System.out.print(m + " ");
        }

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 一趟快排，返回交换后基数的下标
            int index = paritition(array, left, right);
            // 递归排序基数左边的数组
            quickSort(array, left, index-1);
            // 递归排序基数右边的数组
            quickSort(array, index+1, right);
        }
    }
    public static int paritition(int[] array, int left, int right){
        // p为基数，即待排序数组的第一个数
        //Random random = new Random();
        //int randonIndex = random.nextInt(right-left +1) + left;
        //int p = array[randonIndex];
        //array[randonIndex] = array[left];
        //array[left] = p;
        int p = array[left];
        int i = left;
        int j = right;
        while (i < j){
            // 从右往左找第一个小于基数的数(选择最左边为参考，必须先从右边开始找)
            while (array[j] >= p && i < j){
                j--;
            }
            // 从左往右找第一个大于基数的数
            while (array[i] <= p && i < j){
                i++;
            }
            // 找到两个数后进行交换
            swap(array, i, j);
        }
        swap(array, left, i);
        return i;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
