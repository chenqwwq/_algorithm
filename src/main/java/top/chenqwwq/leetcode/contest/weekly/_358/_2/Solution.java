package top.chenqwwq.leetcode.contest.weekly._358._2;

import top.chenqwwq.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/8/13
 **/
public class Solution {
    public ListNode doubleIt(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        final int n = vals.size();

        int num = 0;
        ListNode curNode = new ListNode(-1);
        for (int i = n - 1; i >= 0; i--) {
            final int t = num + vals.get(i) * 2;
            curNode.val = t % 10;
            num = t / 10;
            ListNode node = new ListNode(-1);
            node.next = curNode;
            curNode = node;
        }
        if(num != 0){
            curNode.val = num;
            return curNode;
        }
        return curNode.next;
    }
}