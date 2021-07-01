package construct_a_array;

/**
 @author fujiangnan
 @create 2021-03-12-09-31
 @desc 输入一个整数N,构造一个长度为N的数组,要求对于任意的i<k<j,满足arr[i] + arr[j] ！= arr[k] *2
 */
public class Solution {
    public static void main(String[] args) {
        int size = 10;
        int[] arr = constructArray(size);
        check(arr);
    }

    public static int[] constructArray(int size) {
        if (size == 1) {
            return new int[] {1};
        }

        // 如果不是1，则取数组向上取整的一半长度
        int halfSize = (size + 1) >> 1;
        int[] base = constructArray(halfSize);
        int[] newArray = new int[size];

        // 做奇变换和偶变换
        int index= 0;
        for (; index < halfSize; index++) {
            newArray[index] = (2 * base[index]) + 1;
        }

        for (int i = 0; index < size; i++,index++) {
            newArray[index] = 2 * base[i];
        }
        return newArray;

    }

    public static void check(int[] array) {
        for (int i=0; i< array.length-2; ++i) {
            for (int k = i+1; k < array.length-1; ++k) {
                for (int j = k+1; j < array.length; ++j) {
                    if (array[i] + array[j] == 2 * array[k]) {
                        System.out.println("构造的数组不满足题意！！！");
                        break;
                    }
                }
            }
        }
        System.out.println("构造的数组满足题意！！！");
    }
}
