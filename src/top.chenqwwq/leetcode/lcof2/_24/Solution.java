package top.chenqwwq.leetcode.lcof2._24;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenbingxin
 * @date 2021/12/14
 **/
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null,curr = head;
		while (curr != null){
			final ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
		return pre;
	}
}