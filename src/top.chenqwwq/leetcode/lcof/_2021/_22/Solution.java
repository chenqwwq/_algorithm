package top.chenqwwq.leetcode.lcof._2021._22;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021/6/5
 **/
public class Solution {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode node = head;
		while (--k >= 0) {
			node = node.next;
		}
		while (node != null) {
			node = node.next;
			head = head.next;
		}
		return head;
	}
}