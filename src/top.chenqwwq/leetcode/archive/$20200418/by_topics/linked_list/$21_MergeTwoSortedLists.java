package top.chenqwwq.leetcode.archive.$20200418.by_topics.linked_list;

/**
 * 21. Merge Two Sorted Lists
 * Easy
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * @author chen
 * @date 2019/10/31 下午11:00
 */
public class $21_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode tNode = new ListNode(-1), curr = tNode;
            while (l1 != null && l2 != null) {
                if (l1.val > l2.val) {
                    curr.next = l2;
                    l2 = l2.next;
                } else {
                    curr.next = l1;
                    l1 = l1.next;
                }
                curr = curr.next;
            }
            curr.next = l1 == null ? l2 : l1;

            return tNode.next;

        }
    }
}
