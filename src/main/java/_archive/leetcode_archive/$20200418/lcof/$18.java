package top.chenqwwq.leetcode.archive.$20200418.lcof;

/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * @author chen
 * @date 2020/3/23 下午10:31
 */
public class $18 {
    public class ListHead {
        int val;
        ListHead next;

        ListHead(int x) {
            val = x;
        }
    }

    class Solution {
        public ListHead deleteNode(ListHead head, int val) {
            ListHead tHead = head, preNode = null;
            while (tHead != null) {
                if (tHead.val == val) {
                    if (preNode == null) {
                        return head.next;
                    } else {
                        preNode.next = tHead.next;
                        return head;
                    }
                } else {
                    preNode = tHead;
                    tHead = tHead.next;
                }
            }

            return head;
        }
    }
}
