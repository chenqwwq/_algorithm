package top.chenqwwq.leetcode.archive.$20200418.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CheNbXxx
 * @description
 * @email chenbxxx@gmail.con
 * @date 2019/1/31 15:08
 */
public class LeetCode876 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        /**
         * 转化为数组的形式
         *
         * @param head
         * @return
         */
        public ListNode middleNode(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }
            // 转化为ArrayList的方式
            List<ListNode> list = new ArrayList<>();
            list.add(head);
            while ((head = head.next) != null) {
                list.add(head);
            }
            return list.get(list.size() / 2);
        }

        /**
         * 以二倍速形式，两个遍历节点 一个节点是另外一个的两倍
         *
         * @param head
         * @return
         */
        public ListNode middleNode2(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
