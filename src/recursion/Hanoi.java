package recursion;

/**
 @author fujiangnan
 @create 2021-02-18-10-24
 @desc 汉诺塔问题，经典递归
         时间复杂度的计算
         我们可以看出，用递归来解决汉诺塔问题是非常方便的选择，最后我们来分析一下汉诺塔问题的时间复杂度。
         设盘子个数为n时，需要T（n)步，把A柱子n-1个盘子移到B柱子，需要T（n-1)步，A柱子最后一个盘子移到C柱子一步，B柱子上n-1个盘子移到C柱子上T（n-1)步。
         得递推公式T（n）=2T（n-1)+1
         所以汉诺塔问题的时间复杂度为O(2^n);总步数一定是2^n -1 ;
 */
import java.io.*;

public class Hanoi {
    public static void main(String args[]) throws IOException {
        int n;
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("请输入盘数：");
        n = Integer.parseInt(buf.readLine());

        move(n, 'A', 'B', 'C');
    }

    public static void move(int n, char from, char other, char to) {
        if (n==1) {
            System.out.println("盘" + n + "由" + from + "移动到" + to);
        } else {
            move(n-1, from, to, other);
            System.out.println("盘" + n + "由" + from + "移动到" + to);
            move(n-1, other, from, to);
        }


    }
}
