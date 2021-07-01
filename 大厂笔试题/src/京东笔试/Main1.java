package 京东笔试;

import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-03-27-20-55
 @desc ...
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ans = Sum(arr, row, col);
        System.out.println(ans);
    }
    public static int Sum(int[][] arr, int row, int col) {
        boolean[][] bool = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i==row-1 || j == col - 1 || j == 0) {
                    continue;
                }
                if (arr[i][j] < arr[i-1][j]
                        && arr[i][j] < arr[i][j-1]
                        && arr[i][j] < arr[i+1][j]
                        && arr[i][j] < arr[i][j+1]) {
                    bool[i][j] = true;
                }
            }
        }

        for (int m = 0; m < row; ++m) {
            for (int n =0; n < col; n++) {
                if (bool[m][n] == true) {
                    ++res;
                    infect(bool,m,n);
                }
            }
        }
        return res;
    }

    public static void infect(boolean[][] bool, int i, int j) {
        if (i < 0 || j < 0 || j >= bool[0].length || i >= bool.length || bool[i][j] != true) {
            return;
        }
        bool[i][j] = false;
        infect(bool, i-1, j);
        infect(bool, i+1, j);
        infect(bool, i, j-1);
        infect(bool, i, j+1);


    }
}
