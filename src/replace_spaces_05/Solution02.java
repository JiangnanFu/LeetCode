package replace_spaces_05;

/**
 * 申请一个临时数组
 * 然后再遍历这个字符串的每个字符，如果不是空格就把遍历的字符添加到临时数组中，
 * 如果是空格就添加3个字符'%'，'2'，'0'分别到临时数组中，最后再把临时数组转化为字符串即可。
 *
 * 时间复杂度和空间复杂度均为O(n)
 */
class Solution02 {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] array = new char[len * 3];
        int size = 0;
        for (int i=0; i<len; i++){
            char c = s.charAt(i);
            if (c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else{
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0 ,size);
        return newStr;


    }
}