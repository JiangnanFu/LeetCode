package recursion;

import java.util.Stack;

/**
 @author fujiangnan
 @create 2021-03-24-11-45
 @desc 给你一个栈，在不使用额外数据结构的情况下，将栈逆序，只能用递归的方式
 */
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(){{
            push(3);
            push(2);
            push(1);
        }};
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    /** 递归获取栈的栈底元素，直到栈为空后，将元素压回栈*/
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }


    /**将栈底元素返回，上面的元素直接盖下来*/
    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int last = f(stack);
        stack.push(result);
        return last;
    }


}
