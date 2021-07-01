package 网易笔试题;

/**
 @author fujiangnan
 @create 2021-04-10-16-03
 @desc 加油站问题
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,4,5};
        int[] a2 = new int[]{3,4,5,1,2};
        int ans = canCompleteRace(a1,a2);
        System.out.println(ans);
    }
    public static int canCompleteRace (int[] e, int[] c) {

        int start = 0;
        int curSum = 0;
        int totalSum = 0;
        for (int i = 0; i < e.length; i++) {
            curSum += e[i] - c[i];
            totalSum += e[i] - c[i];
            if (curSum<0){
                start = i+1;
                curSum = 0;
            }

        }
        if (totalSum < 0) {return -1;}
        return start;
    }
}
