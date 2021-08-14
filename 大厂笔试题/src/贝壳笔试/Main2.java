package 贝壳笔试;

import java.util.ArrayList;
import java.util.Arrays;

/**
 @author fujiangnan
 @create 2021-08-13-20-28
 @desc ...
 */
public class Main2 {
    public static void main(String[] args) {
        String s = "aabbccaabbdd";
        int k = 1;
        String s1 = NS_String(s, k);
        System.out.println(s1);

    }
    public static String NS_String (String s, int k) {
        // write code here
        char[] arr = s.toCharArray();
        char[] array = s.toCharArray();
        Arrays.sort(array);
        ArrayList<Character> integers = new ArrayList<>();
        integers.add(array[0]);
        for (int i = 0; i < arr.length-1; i++) {
            if (array[i+1] != array[i]){
                integers.add(array[i+1]);
            }
        }
        if (k >= integers.size()){
            return new String();
        }
        for (int i = 0; i < k; i++) {
            char temp = integers.get(i);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == temp){
                    arr[j] = 'A';
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'A'){
                stringBuffer.append(arr[i]);
            }
        }
        return stringBuffer.toString();
    }
}
