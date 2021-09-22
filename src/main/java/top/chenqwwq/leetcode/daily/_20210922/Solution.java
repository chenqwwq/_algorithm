package top.chenqwwq.leetcode.daily._20210922;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021-09-22
 **/
public class Solution {
	public ListNode[] splitListToParts(ListNode head, int k) {
		if (head == null) {
			return new ListNode[k];
		}
		// 获取链表长度
		int len = 0;
		ListNode curr = head;
		while (curr != null) {
			len++;
			curr = curr.next;
		}

		// 获取拆分
		final ListNode[] ans = new ListNode[k];
		final int par = len / k;
		int size = len % k, idx = 0;
		while (head != null) {
			final int p = par + (size-- > 0 ? 1 : 0);
			ans[idx++] = head;
			ListNode last = null;
			for (int i = 0; i < p && head != null; i++) {
				if (i == p - 1) {
					last = head;
				}
				head = head.next;
			}
			if (last != null) {
				last.next = null;
			}
		}
		return ans;
	}
}