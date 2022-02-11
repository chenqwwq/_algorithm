package top.chenqwwq.leetcode.lcof._2021._25;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode fake = new ListNode(-1), node = fake;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		while (l1 != null) {
			node.next = l1;
			l1 = l1.next;
			node = node.next;
		}
		while (l2 != null) {
			node.next = l2;
			l2 = l2.next;
			node = node.next;
		}

		return fake.next;
	}
}