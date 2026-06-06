package top.chenqwwq.leetcode.archive.$20200418.by_topics.linked_list;

/**
 * 203. Remove Linked List Elements
 * Easy
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @author chen
 * @date 2019/10/31 下午11:32
 */
public class $203_RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            // 遍历首节点,直到首节点不等于val
            while (head != null && head.val == val) {
                head = head.next;
            }
            // 排除全链表等于val的情况
            if (head == null) {
                return null;
            }

            // 记录首节点
            ListNode curr = head;

            // 后续节点
            while (curr.next != null) {
                // 判断相同时删除节点
                if (curr.next.val == val) {
                    // 此时curr节点不需要变化
                    curr.next = curr.next.next;
                    continue;
                }

                // 没有
                curr = curr.next;
            }

            return head;
        }
    }
}
