package 美团面试题;

import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-03-13-15-03
 @desc 美团面试题
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                    int temp = in.nextInt();
                    arr[i][j] = temp;
                }
            }

    int[][] ans = transpose(arr);
        for (int m = 0; m < row; ++m) {
            for (int n = 0; n < col; ++n) {
                System.out.print(ans[m][n]);
                System.out.print(' ');

                if (n == col-1) {
                    System.out.println();
                }
            }
        }
    }

    public static int[][] transpose(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = arr[i][j];
            }
        }
        return res;
    }
}





