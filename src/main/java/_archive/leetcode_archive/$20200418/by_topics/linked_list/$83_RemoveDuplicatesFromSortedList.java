package top.chenqwwq.leetcode.archive.$20200418.by_topics.linked_list;

/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @author chen
 * @date 2019/10/31 下午11:09
 */
public class $83_RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode theHead = head;

            while (head != null && head.next != null) {
                if (head.next.val == head.val) {
                    head.next = head.next.next;
                    continue;
                }

                head = head.next;
            }

            return theHead;
        }
    }
}
