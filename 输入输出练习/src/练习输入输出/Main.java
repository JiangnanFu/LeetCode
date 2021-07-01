package 练习输入输出;
import java.util.*;
/**
 @author fujiangnan
 @create 2021-03-17-20-24
 @desc ...
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int len = sc.nextInt();
            if (len == 0) {
                break;
            }
            int[] arr = new int[len];
            for (int i=0; i<len; ++i) {
                arr[i] = sc.nextInt();
            }
            System.out.println(sum(arr));
        }
    }
    public static int sum(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; ++i) {
            sum += arr[i];
        }
        return sum;
    }

}
