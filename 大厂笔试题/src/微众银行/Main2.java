package 微众银行;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-05-13-19-35
 @desc ...
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();//蓄水池数量
        int num2 = sc.nextInt();// 管道数量
        int[] arr = new int[num1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] arr2 = new int[num2][2];
        for (int i = 0; i < num2; i++) {
            int[] temp = new int[2];
            temp[0] = sc.nextInt();
            temp[1] = sc.nextInt();
            arr2[i] = temp;
        }
        float[] res = v(arr, arr2);
        for (float f :
                res) {
            System.out.println(f);
        }

    }

    public static float[] v(int[] arr, int[][] arr2) {
        float[] ans = new float[arr.length];
        Arrays.sort(arr2, (a,b)-> a[0]==b[0] ? a[0]-b[0] : a[1]-b[1]);
        float value = arr[arr2[0][0]-1] + arr[arr2[0][1]-1];
        int start = arr2[0][0]-1;
        int last = arr2[0][1]-1;
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i][0] == arr2[i-1][1]) {
                value += arr[arr2[i][1]-1];
                last = arr2[i][1] - 1;
            } else {
                int len = last - start + 1;
                float temp = value / (float) len;
                BigDecimal decimal = new BigDecimal(temp);
                float v = decimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                for (int j = start; j < start+len; j++) {
                    ans[j] = v;
                }
                start = arr2[i][0] - 1;
                last = arr2[i][1] - 1;
                value = arr[arr2[i][0]-1] + arr[arr2[i][1]-1];
                if (i == arr2.length - 1) {
                    int len2 = last - start + 1;
                    float temp2 = value / (float) len2;
                    BigDecimal decimal2 = new BigDecimal(temp2);
                    float v2 = decimal2.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
                    for (int j = start; j < start + len2; j++) {
                        ans[j] = v2;
                    }
                }
            }
        }
        return ans;
    }

}
