package top.chenqwwq.leetcode.contest.weekly._265._2;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021-11-01
 **/
public class Solution {
	public int[] nodesBetweenCriticalPoints(ListNode head) {
		int min = Integer.MAX_VALUE;
		ListNode prev = head, curr = head.next;
		int first = -1, last = -1, i = 1;
		while (curr.next != null) {
			final ListNode next = curr.next;
			if ((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)) {
				if (first == -1) {
					first = i;
				} else {
					min = Math.min(min, i - last);
				}
				last = i;
			}
			//
			i++;
			prev = curr;
			curr = next;
		}
		return first == last ? new int[]{-1, -1} : new int[]{min, last - first};
	}
}