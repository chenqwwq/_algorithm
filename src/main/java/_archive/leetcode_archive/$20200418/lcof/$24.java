package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author chen
 * @date 2020/4/11 下午1:26
 */
public class $24 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode curr = null, pre = head;
            ListNode tempNode;
            while (pre != null) {
                tempNode = pre.next;
                pre.next = curr;
                curr = pre;
                pre = tempNode;
            }

            return curr;
        }
    }
}
