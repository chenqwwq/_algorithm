package top.chenqwwq.leetcode.unkown._2;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021-11-02
 **/
public class Solution {
	private static final ListNode ZERO = new ListNode(0);

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode fake = new ListNode(-1), head = fake;
		int carry = 0;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				l1 = ZERO;
			}
			if (l2 == null) {
				l2 = ZERO;
			}
			int tmp = l1.val + l2.val + carry;
			carry = tmp / 10;
			head.next = new ListNode(tmp % 10);
			head = head.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if (carry != 0) {
			head.next = new ListNode(carry);
		}
		return fake.next;
	}
}