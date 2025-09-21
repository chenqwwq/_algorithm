package top.chenqwwq.leetcode.daily._2023._20230731;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2023/7/31
 **/
public class Solution {
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        final ListNode mid = mid(head);
        ListNode next = mid.next;
        mid.next = null;
        union(head, reverse(next));
    }

    public ListNode union(ListNode n1, ListNode n2) {
        ListNode fake = new ListNode(-1), cur = fake;
        while (n1 != null && n2 != null) {
            cur.next = n1;
            n1 = n1.next;
            cur = cur.next;
            cur.next = n2;
            n2 = n2.next;
            cur = cur.next;
        }
        if(n1 != null) cur.next = n1;
        if(n2 != null) cur.next = n2;
        return fake.next;
    }

    public ListNode reverse(ListNode node) {
        ListNode cur = node,next = node.next;
        cur.next = null;
        while (next != null) {
            final ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }

        return cur;
    }


    public ListNode mid(ListNode node) {
        // 获取链表中间节点
        ListNode mid = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        return mid;
    }
}