package top.chenqwwq.leetcode.daily._20201020;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @author chen
 * @date 2020-10-20
 **/

public class Solution {
    // 获取中间节点
    public ListNode getMiddleNode(ListNode head) {
        // 1,2,3,4,5 -> 3
        // 1,2,3,3,4 -> 2
        // 找到链表的中间节点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        // 从slow开始翻转后半部分的链表
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 合并链表
    public ListNode mergeList(ListNode h1, ListNode h2) {
        // head1在前
        ListNode fake = new ListNode(-1);
        while (h1 != null && h2 != null) {
            fake.next = h1;
            ListNode t1 = h1.next;
            fake = fake.next;
            h1 = t1;
            fake.next = h2;
            fake = fake.next;
            h2 = h2.next;
        }
        while (h1 != null) {
            fake.next = h1;
            h1 = h1.next;
            fake = fake.next;
        }

        return fake.next;
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 获取中间节点
        ListNode middleNode = getMiddleNode(head);
        // 断开后续节点
        ListNode node = middleNode.next;
        middleNode.next = null;
        final ListNode head2 = reverseList(node);

        head = mergeList(head, head2);
    }
}