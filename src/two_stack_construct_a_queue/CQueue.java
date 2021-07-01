package two_stack_construct_a_queue;

import java.util.Stack;

/**
 * @author fujiangnan
 * @create 2020-12-05 10:01:22
 * @desc:
 *  Your CQueue object will be instantiated and called as such:
 *  CQueue obj = new CQueue();
 *  obj.appendTail(value);
 *  int param_2 = obj.deleteHead();
 *
 */
public class CQueue {
    // 先声明
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        // 定义
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
                return s2.pop();
            }
        }
        if (s2.isEmpty()){
            return -1;
        }else{
            return s2.pop();
        }

    }

}
