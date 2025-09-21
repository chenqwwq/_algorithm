package top.chenqwwq.leetcode.contest.cnunionpay2022._1;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2022/9/19
 **/
public class Solution {

    public ListNode reContruct(ListNode head) {
        if (head == null) return null;
        if((head.val & 1) == 0) head = reContruct(head.next);
        else head.next = reContruct(head.next);
        return head;
    }
}