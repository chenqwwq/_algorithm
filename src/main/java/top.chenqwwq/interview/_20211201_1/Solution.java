package top.chenqwwq.interview._20211201_1;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenbingxin
 * @date 2021/12/1
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getSimpleName());
    }

    // 1 2 3 2 1
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = reorder(slow);
        while (half != null && head != null) {
            if (head.val != half.val) {
                return false;
            }
            head = head.next;
            half = half.next;
        }
        return true;
    }

    public ListNode reorder(ListNode node) {
        // 3 2 1
        ListNode pre = node, curr = node.next;
        pre.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}