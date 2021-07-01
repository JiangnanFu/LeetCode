package replace_spaces_05;

/**
 * Java 解法流程：
 *   初始化一个 StringBuilder ，记为 res ；
 *   遍历字符串 s 中的每个字符 c ：
 *   当 c 为空格时：向 res 后添加字符串 "%20"；
 *   当 c 不为空格时：向 res 后添加字符 c ；
 *   将 res 转化为 String 类型并返回。
 *
 * 复杂度分析：
 *
 *     时间复杂度 O(N)： 遍历使用 O(N) ，每轮添加（修改）字符操作使用 O(1) ；
 *     空间复杂度 O(N)： Java 新建的 StringBuilder 都使用了线性大小的额外空间。
 */
class Solution01 {
    public String replaceSpace(String s) {

        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == ' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();

    }
}