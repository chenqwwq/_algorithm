package top.chenqwwq.leetcode.daily._2026._20260614;

import top.chenqwwq.leetcode.common.ListNode;

public class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            ListNode t = slow.next;
            slow.next = pre;
            pre = slow;
            slow = t;
        }
        ListNode t = slow.next;
        slow.next = pre;
        pre = slow;
        slow = t;

        int max = -1;
        while (slow != null) {
            max = Math.max(max, slow.val + pre.val);
            slow = slow.next;
            pre = pre.next;
        }
        return max;
    }
    // 1 2 3 4 5 6 7 8
    // 1 1
    // 2 3
    // 3 5
    // 4 7
}