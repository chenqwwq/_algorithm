package top.chenqwwq.leetcode.archive.$20200418.lcof;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 *
 * @author chen
 * @date 2020/3/6 下午3:12
 */
public class $06 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();

            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }

            final int size = stack.size();
            int[] res = new int[size];

            for (int i = 0; i < size; i++) {
                res[i] = stack.pop();
            }

            return res;
        }
    }
}
