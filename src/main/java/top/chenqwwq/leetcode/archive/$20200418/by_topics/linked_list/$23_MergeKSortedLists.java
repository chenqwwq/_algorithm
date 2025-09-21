package top.chenqwwq.leetcode.archive.$20200418.by_topics.linked_list;

/**
 * 23. 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author chen
 * @date 2019/12/20 下午11:13
 */
public class $23_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return recursive(lists, 0, lists.length - 1);
        }

        private ListNode recursive(ListNode[] listNodes, int left, int right) {
            if (left > right) {
                return null;
            }
            if (left == right) {
                return listNodes[left];
            }

            final int mid = left + right >> 1;
            return merge2List(recursive(listNodes, left, mid), recursive(listNodes, mid + 1, right));
        }

        private ListNode merge2List(ListNode head1, ListNode head2) {
            ListNode head = new ListNode(-1), temp = head;

            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    temp.next = head1;
                    head1 = head1.next;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                }
                temp = temp.next;

            }

            // 拼接剩余部分
            while (head1 != null) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }

            while (head2 != null) {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }

            return head.next;
        }
    }
}
