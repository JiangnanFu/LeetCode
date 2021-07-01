package 美团面试题;

import java.util.*;

/**
 @author fujiangnan
 @create 2021-03-13-16-33
 @desc 美团笔试题
 */
public class Main2 {
    private  static  List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<List<Integer>> ans = findNumber(s);
        for (int i=0; i<ans.size(); ++i) {

            System.out.println(ans.get(i));
        }

    }
    public static List findNumber(String s) {
        int len = s.length();
        int i=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (; i < len-1; i++) {
            while (s.charAt(i) >= '0' && s.charAt(i) <='9' && i<len) {
                list.add(Integer.valueOf(String.valueOf(s.charAt(i))));
                ++i;
            }
            StringBuilder builder = new StringBuilder();
            if (list.size() != 0) {
                for (int j = 0; j < list.size(); j++) {
                    builder.append(list.get(j));
                }
                String st = builder.toString();
                int len1 = st.length();
                int temp = 0;
                for (int k = 0; k < len1; k++) {
                    while (st.charAt(k) == '0') {
                        ++k;
                    }
                    temp = k;
                    break;
                }
                st.substring(temp,len1);
                res.add(Integer.valueOf(st));
                list.clear();
            }
        }
        Collections.sort(res);
        return res;
    }
}
