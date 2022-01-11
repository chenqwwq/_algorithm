package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author chen
 * @date 2020/4/11 下午1:42
 */
public class $25 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode fakeHead = new ListNode(-1), temp = fakeHead;
            while (l1 != null && l2 != null) {
                if (l1.val >= l2.val) {
                    temp.next = l2;
                    l2 = l2.next;
                } else {
                    temp.next = l1;
                    l1 = l1.next;
                }
                temp = temp.next;
            }

            while (l1 != null) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }

            while (l2 != null) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }

            return fakeHead.next;
        }
    }
}
