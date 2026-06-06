package top.chenqwwq.leetcode.daily._2023._20230729;

import top.chenqwwq.leetcode.common.ListNode;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author chenqwwq
 * @date 2023/7/31
 **/
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        return fast == null || fast.next == null;
    }
}