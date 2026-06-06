package top.chenqwwq.leetcode.contest.weekly._270._2;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenbingxin
 * @date 2021/12/5
 **/
public class Solution {
	public ListNode deleteMiddle(ListNode head) {
		if(head == null || head.next == null){
			return null;
		}
		ListNode fast = head.next,slow = head;
		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;

	}
}