package 广联达笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 @author fujiangnan
 @create 2021-05-12-18-26
 @desc 72%通过率
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] array = s.toCharArray();
        int ans = maxValue(array);
        System.out.println(ans);

    }
    public static int maxValue(char[] array) {
        if (array.length == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int res = -1;
        int i=0;
        while (i < array.length) {
            if (array[i] >= 'a' && array[i] <= 'z') {
                set.add(array[i]);
            } else {
                if (set.size() > res) {
                    res = set.size();
                    set = new HashSet<>();
                }
            }
            ++i;
        }
        if (res == -1 || res < set.size()) {
            res = set.size();
        }
        return res;
    }
}
