package top.chenqwwq.leetcode.lcof._2021._18;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021/6/3
 **/
public class Solution {
	public ListNode deleteNode(ListNode head, int val) {
		final ListNode fake = new ListNode(-1);
		fake.next = head;
		ListNode node = head, pre = fake;
		while (node != null) {
			if (node.val == val) {
				pre.next = node.next;
				break;
			}
			pre = pre.next;
			node = node.next;
		}
		return fake.next;
	}
}