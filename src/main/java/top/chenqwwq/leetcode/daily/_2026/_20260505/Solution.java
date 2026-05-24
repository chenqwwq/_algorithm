package top.chenqwwq.leetcode.daily._2026._20260505;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2026/5/5
 **/
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int len = 1;        // 链表长度
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        tail.next = head;
        k %= len;
        k = len - k;

        for (int i = 0; i < k; i++) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }
}