package top.chenqwwq.leetcode.archive.lcof2._28;

import top.chenqwwq.leetcode.common.Node;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Solution {
	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		final Node next = head.next;
		head.next = null;
		if (head.child != null) {
			final Node flatten = flatten(head.child);
			head.child = null;
			head.next = flatten;
			if (flatten != null) {
				flatten.prev = head;
			}
		}
		if (next != null) {
			Node fake = head;
			while (fake.next != null) {
				fake = fake.next;
			}
			final Node flatten = flatten(next);
			fake.next = flatten;
			if (flatten != null) {
				flatten.prev = fake;
			}
		}
		return head;
	}
}