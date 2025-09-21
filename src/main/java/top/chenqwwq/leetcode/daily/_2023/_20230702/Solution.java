package top.chenqwwq.leetcode.daily._2023._20230702;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2023/7/2
 **/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode fake = new ListNode(-1), head = fake;
        while (l1 != null && l2 != null) {
            final int sum = l1.val + l2.val + flag;
            head.next = new ListNode(sum % 10);
            flag = sum / 10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            final int sum = l1.val + flag;
            head.next = new ListNode(sum % 10);
            flag = sum / 10;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            final int sum = l2.val + flag;
            head.next = new ListNode(sum % 10);
            flag = sum / 10;
            head = head.next;
            l2 = l2.next;
        }
        if (flag != 0) head.next = new ListNode(flag);
        return fake.next;
    }

}