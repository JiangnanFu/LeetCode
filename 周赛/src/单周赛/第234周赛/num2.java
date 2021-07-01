package 单周赛.第234周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 @author fujiangnan
 @create 2021-03-28-10-10
 @desc 5714. 替换字符串中的括号内容（AC）
 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。

 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。

 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。

 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：

 将 keyi 和括号用对应的值 valuei 替换。
 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。

 knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。

 请你返回替换 所有 括号对后的结果字符串。
 */
public class num2 {
    public static void main(String[] args) {
        String s = "hi(name)";
        List<List<String>> knowledge  = new ArrayList<>();
        knowledge.add(new ArrayList<>(Arrays.asList(new String[]{"a", "b"})));
        //knowledge.add(new ArrayList<>(Arrays.asList(new String[]{"age","two"})));
        String ans = evaluate(s, knowledge);
        System.out.println(ans);

    }
    public static String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for (int i=0;i <knowledge.size(); ++i) {
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            while (i < s.length() && s.charAt(i) != '('){
                buffer.append(s.charAt(i));
                ++i;
            }
            ++i;
            StringBuilder builder = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ')') {
                builder.append(s.charAt(i));
                ++i;
            }
            if (builder.length() > 0) {
                if (map.get(builder.toString()) != null) {
                    buffer.append(map.get(builder.toString()));
                } else {
                    buffer.append('?');
                }
            }


        }
        return buffer.toString();
    }
}
