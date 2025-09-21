package top.chenqwwq.leetcode.contest.biweek._110._2;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2023/8/8
 **/
public class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        final ListNode next = head.next;
        final int val = get(head.val, next.val);
        head.next = new ListNode(val,next);
        insertGreatestCommonDivisors(next);
        return head;
    }

    public int get(int a, int b) {
        if (a == 1 || b == 1) return 1;
        int mmin = Math.min(a, b);
        for (int i = mmin; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }
}