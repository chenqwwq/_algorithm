package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 19-7-20 下午4:23
 */
public class LeetCode24 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        new LeetCode24().new Solution().swapPairs(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            // 排除异常情况
            if (head == null || head.next == null) {
                return head;
            }
            // 结果头结点
            ListNode tempHead = new ListNode(-1), preNode = tempHead, nextNode;
            while (head != null && (nextNode = head.next) != null) {
                // 前置节点指向当前head的下一个节点
                preNode.next = nextNode;
                head.next = nextNode.next;
                // 下一个节点逆序指向前一个节点
                nextNode.next = head;

                preNode = head;
                head = head.next;
            }

            return tempHead.next;
        }
    }
}
