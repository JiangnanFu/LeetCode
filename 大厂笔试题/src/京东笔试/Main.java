package 京东笔试;

import java.util.HashMap;
import java.util.Scanner;

/**
 @author fujiangnan
 @create 2021-03-27-18-51
 @desc 京东笔试
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String input = sc.nextLine();
        for (int i = 0; i<input.length(); i++) {
            if (input.charAt(i) == 'C') {
                StringBuilder builder = new StringBuilder();
                while (i+1<input.length() && input.charAt(i+1) != 'N'
                        && input.charAt(i+1) != 'H'
                        && input.charAt(i+1) != 'C'
                        && input.charAt(i+1) != 'O') {
                    builder.append(input.charAt(i+1));
                    ++i;
                }
                if (builder.length() > 0) {
                    sum += Integer.parseInt(builder.toString()) * 12;
                } else {
                    sum += 12;
                }

            }
            if (input.charAt(i) == 'N') {
                StringBuilder builder = new StringBuilder();
                while (i+1<input.length() && input.charAt(i+1) != 'N'
                        && input.charAt(i+1) != 'H'
                        && input.charAt(i+1) != 'C'
                        && input.charAt(i+1) != 'O') {
                    builder.append(input.charAt(i+1));
                    ++i;
                }
                if (builder.length() > 0) {
                    sum += Integer.parseInt(builder.toString()) * 14;
                } else {
                    sum += 14;
                }
            }
            if (input.charAt(i) == 'O') {
                StringBuilder builder = new StringBuilder();
                while (i+1<input.length() && input.charAt(i+1) != 'N'
                        && input.charAt(i+1) != 'H'
                        && input.charAt(i+1) != 'C'
                        && input.charAt(i+1) != 'O') {
                    builder.append(input.charAt(i+1));
                    ++i;
                }
                if (builder.length() > 0) {
                    sum += Integer.parseInt(builder.toString()) * 16;
                } else {
                    sum += 16;
                }
            }
            if (input.charAt(i) == 'H') {
                StringBuilder builder = new StringBuilder();
                while (i+1<input.length() && input.charAt(i+1) != 'N'
                        && input.charAt(i+1) != 'H'
                        && input.charAt(i+1) != 'C'
                        && input.charAt(i+1) != 'O') {
                    builder.append(input.charAt(i+1));
                    ++i;
                }
                if (builder.length() > 0) {
                    sum += Integer.parseInt(builder.toString());
                } else {
                    sum += 1;
                }
            }
        }
        System.out.println(sum);

    }

}
