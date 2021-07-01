package 网易笔试题;
import java.util.*;
/**
 @author fujiangnan
 @create 2021-04-10-15-46
 @desc 链表的两数相加
 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

 请你将两个数相加，并以相同形式返回一个表示和的链表。

 你可以假设除了数字 0 之外，这两个数都不会以 0开头
 */
public class Solution1 {

    public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode head1 = node1;
        node1.next = new ListNode(2);
        node1 = node1.next;
        node1.next = new ListNode(4);
        node1 = node1.next;
        ListNode node2 = new ListNode(-1);
        ListNode head2 = node2;
        node2.next = new ListNode(2);
        node2 = node2.next;
        node2.next = new ListNode(3);
        node2 = node2.next;

        ListNode ans = reverse(minusList(head1, head2));

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
    public static ListNode minusList (ListNode minuendList, ListNode subtrahendList) {
        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();

        int val1 = minuendList.val;
        int val2 = subtrahendList.val;

        ListNode head1 = minuendList;
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        ListNode head2 = subtrahendList;
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        int convey = 0;
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (val1 >0 && val2 < 0) {
                int temp1 = stack1.size() == 0 ? 0 : stack1.pop().val;
                int temp2 = stack2.size() == 0 ? 0 : Math.abs(stack2.pop().val);
                int i = (temp1 + temp2 +convey)%10;
                temp.next = new ListNode(i);
                temp = temp.next;
                convey = (temp1 +temp2+convey) / 10;
            }

        }
        return res.next;


    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
