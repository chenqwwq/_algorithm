package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 61. 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author bingxin.chen
 * @date 2019/7/18 12:11
 */
public class LeetCode61 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;

        ListNode listNode = new LeetCode61().new Solution().rotateRight(listNode1, 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }

            // 遍历取数组长度
            int i = 1;
            ListNode t = head;
            while (t.next != null) {
                i++;
                t = t.next;
            }

            if (k % i == 0) {
                return head;
            }

            // 取最终的头结点
            int resHeadIndex = i - (k % i) + 1;
            ListNode pre = null, resHead = head;
            while (--resHeadIndex > 0) {
                pre = resHead;
                resHead = resHead.next;
            }

            //
            if (pre != null) {
                pre.next = null;
            }

            // 尾接头
            t.next = head;

            return resHead;
        }
//        public ListNode rotateRight(ListNode head, int k) {
//            if (head == null || head.next == null || k == 0) {
//                return head;
//            }
//
//            // 知道链表长度可以取余确定右移后的头节点
//            // 现在不知道的时候可以顺序遍历
//            ListNode pre = null, resHead = head, tail = null;
//
//            while (--k > 0) {
//                pre = resHead;
//                // 遍历到链表末尾的时候重新接到head
//                if (resHead.next != null) {
//                    resHead = resHead.next;
//                } else {
//                    tail = resHead;
//                    resHead = head;
//                }
//            }
//
//            // 断开原来的链接
//            if (pre != null) {
//                pre.next = null;
//            }
//
//            // 尾部拼接
//            if (tail == null) {
//                ListNode node = resHead;
//                while (node.next != null) {
//                    node = node.next;
//                }
//                tail = node;
//            }
//
//            tail.next = head;
//
//            return resHead;
//        }
    }
}
