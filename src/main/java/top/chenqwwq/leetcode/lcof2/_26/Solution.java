package top.chenqwwq.leetcode.lcof2._26;

import top.chenqwwq.leetcode.common.ListNode;

import java.util.Stack;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Solution {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		Stack<ListNode> stack = new Stack<>();
		ListNode fake = head;
		while (fake != null) {
			stack.add(fake);
			fake = fake.next;
		}

		fake = head;
		final int size = stack.size();
		int cnt = size >> 1;
		while (cnt-- >= 0) {
			ListNode temp = fake.next, pop = stack.pop();
			fake.next = pop;
			pop.next = temp;
			fake = temp;
		}
		if ((size & 1) == 1) {
			fake.next.next = null;
		} else {
			fake.next = null;
		}
	}
}