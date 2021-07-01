package 广联达笔试;

import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-05-12-19-41
 @desc ...
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l = sc.nextLine();
        int len = Integer.parseInt(l);
        char[][] arr = new char[len][len];
        for (int i = 0; i < len; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < len; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        char[] ans = orderPrint(arr);
        System.out.println(String.valueOf(ans));
    }
    public static char[] orderPrint(char[][] arr) {
        if (arr.length == 0) {
            return new char[0];
        }
        int left = 0;
        int right = arr[0].length-1;
        int t = 0;
        int bottom = arr.length - 1;
        int x = 0;
        char[] res = new char[(right+1)*(bottom+1)];
        while(true) {
            for (int i = left; i <=right ; i++) {
                if (arr[t][i] == '0') {
                    continue;
                }
                res[x++] = arr[t][i];
            }
            if (++t > bottom) {
                break;
            }
            for (int i = t; i <= bottom ; i++) {
                if (arr[i][right] == '0') {
                    continue;
                }
                res[x++] = arr[i][right];
            }
            if (left > --right) {
                break;
            }
            for (int i = right; i >= left ; i--) {
                if (arr[bottom][i] == '0') {
                    continue;
                }
                res[x++] = arr[bottom][i];
            }
            if (t > --bottom) {
                break;
            }
            for (int i = bottom; i >=t ; i--) {
                if (arr[i][left] == '0') {
                    continue;
                }
                res[x++] = arr[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
