package 练习输入输出;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-03-19-13-23
 @desc 将输入转化为一个数组
 */
public class InputToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("输入一串数据，以逗号隔开");
        // 读取输入的一行，nextLine()是以回车为结束符；
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("")) {
                break;
            }
            // 以空格进行分割
            String[] arr = s.split(" ");
            list.add(new ArrayList<String>(Arrays.asList(arr)));
        }
        scanner.close();
        int row = list.size();
        int col = list.get(0).size();
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = Integer.parseInt(list.get(i).get(j));
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(ans[i][j]);
                if (j == col - 1) {
                    System.out.println();
                }
            }
        }
    }

}
