package top.chenqwwq.leetcode.week._267._2;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021/11/17
 **/
public class Solution {

	// [5,2,6,3,9,1,7,3,8,4]
	public ListNode reverseEvenLengthGroups(ListNode head) {
		int i = 0;
		ListNode prev = head, node = head;
		while (node != null) {
			if ((++i & 1) == 0) {
				final ListNode[] res = reverse(node, i - 1);
				prev.next = res[0];
				node.next = res[1];
				node = res[1];
			} else {
				for (int c = 0; c < i && node != null; c++) {
					prev = node;
					node = node.next;
				}
			}
		}
		return head;
	}

	public ListNode[] reverse(ListNode node, int ml) {
		if (node == null) {
			return new ListNode[]{node, null};
		}
		ListNode prev = node, next = prev.next;
		int i = 0;
		while (next != null && i++ < ml) {
			// 三点转换
			ListNode t = next.next;
			next.next = prev;
			prev = next;
			next = t;
		}
		node.next = next;
		return new ListNode[]{prev, next};
	}
}