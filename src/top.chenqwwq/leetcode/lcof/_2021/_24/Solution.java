package top.chenqwwq.leetcode.lcof._2021._24;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode pre = head, cur = head.next, next;
		head.next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		return pre;

	}
}