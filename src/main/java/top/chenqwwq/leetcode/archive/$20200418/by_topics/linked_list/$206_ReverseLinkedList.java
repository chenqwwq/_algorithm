package top.chenqwwq.leetcode.archive.$20200418.by_topics.linked_list;

/**
 * 206. Reverse Linked List
 * Easy
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * @author bingxin.chen
 * @date 2019/10/30 13:08
 */
public class $206_ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            // 三点翻转
            if (head == null || head.next == null) {
                return head;
            }

            // 分别为前驱 当前 后继
            // 每次翻转前驱和当前
            // 当前变为前驱 临时记录的节点变为当前
            ListNode pre = head, curr = head.next, next;
            while (curr != null) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            head.next = null;

            return pre;
        }
    }
}
