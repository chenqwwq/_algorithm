package top.chenqwwq.leetcode.daily._20210924;

import top.chenqwwq.leetcode.common.Node;

/**
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * [1,2,null,3]
 * []
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *
 * @author chen
 * @date 2021-09-24
 **/
public class Solution {
	public Node flatten(Node head) {
		if (head == null) {
			return null;
		}

		Node fake = head, prev = null, next = null;
		while (fake != null || next != null) {
			if (fake == null) {
				fake = next;
				prev.next = next;
				next.prev = prev;
				next = null;
			}
			// 如果存在下层节点,递归摊平
			if (fake.child != null) {
				next = fake.next;
				final Node flatten = flatten(fake.child);
				fake.next = flatten;
				flatten.prev = fake;
				fake.child = null;
			}
			prev = fake;
			fake = fake.next;
		}
		return head;
	}
}