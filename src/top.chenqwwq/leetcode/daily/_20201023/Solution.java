package top.chenqwwq.leetcode.daily._20201023;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author chen
 * @date 2020-10-23
 **/
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 快慢指针，一边遍历一遍翻转前半链表
        ListNode fast = head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 1,2,3,4,5 -> null <- 1 <- 2
        ListNode f1 = prev, f2;
        if (fast != null) {
            f2 = curr.next;
        } else {
            f2 = curr;
        }
        while (f1 != null || f2 != null) {
            if (f1 == null || f2 == null) {
                return false;
            }
            if (f1.val != f2.val) {
                return false;
            }
            f1 = f1.next;
            f2 = f2.next;
        }

        return true;
    }
}