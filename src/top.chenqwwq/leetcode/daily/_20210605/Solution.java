package top.chenqwwq.leetcode.daily._20210605;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode fake = new ListNode(-1, head), pre = fake;

		while (head != null) {
			if (head.val == val) {
				// 移除节点
				pre.next = head.next;
			} else {
				pre = head;
			}
			head = head.next;
		}
		return fake.next;
	}
}