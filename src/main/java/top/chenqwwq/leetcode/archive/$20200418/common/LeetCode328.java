package top.chenqwwq.leetcode.archive.$20200418.common;

/**
 * 328. 奇偶链表
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author bingxin.chen
 * @date 2019/7/17 12:23
 */
public class LeetCode328 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            // 记录下第一个偶数节点
            ListNode sign = head.next;
            ListNode node1 = head, node2 = head.next;
            // 记录此时的n2是奇还是偶
            boolean flag = true;
            // 自己画图表示，差不多就是每次都从原链表挂下一个元素
            // 偶数链表以sign为头节点
            while (node2.next != null) {

                node1.next = node2.next;

                node1 = node2;
                node2 = node1.next;
                flag = !flag;
            }

            if (flag) {
                node1.next = node2;
            } else {
                node1.next = null;
                node2.next = sign;
            }
            return head;

        }
    }
}
