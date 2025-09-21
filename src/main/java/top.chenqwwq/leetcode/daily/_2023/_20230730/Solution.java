package top.chenqwwq.leetcode.daily._2023._20230730;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2023/7/31
 **/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}