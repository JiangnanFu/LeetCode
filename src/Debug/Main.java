package Debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @author fujiangnan
 @create 2021-03-27-18-17
 @desc ...
 */
public class Main {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> ans = partitionLabels(S);
        for (int i :
                ans) {
            System.out.println(i);
        }

    }
    public static List<Integer> partitionLabels(String S) {
        if (S.length() == 1) {
            return new ArrayList<>(1);
        }
        List<Integer> ans = new ArrayList<>();
        // 用hashmap统计每个字符结束的位置
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0; i<S.length(); ++i) {
            map.put(S.charAt(i), i);
        }

        int start = 0;
        int end = map.get(S.charAt(0));
        int j = 1;
        while (j < S.length()) {
            if (j < end) {
                end = Math.max(end, map.get(S.charAt(j)));
                ++j;
            }
            if (j == end) {
                ans.add(end - start +1);
                start = j;
                end = map.get(S.charAt(j));
                ++j;
            }
        }
        return ans;
    }
}
