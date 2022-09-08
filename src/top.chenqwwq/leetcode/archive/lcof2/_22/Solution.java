package top.chenqwwq.leetcode.archive.lcof2._22;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * 快慢指针的实现：
 * 快指针走过的路程是慢指针的两倍，相遇说明多走一个环的距离,并且慢指针也走了一个环的距离。
 * 此时假设环入口到相遇点的距离为m，则入口距离起点就是 k-m，因为慢指针只走了k步，而快指针再走k-m也能到入口
 *
 * @author chenbingxin
 * @date 2021/12/14
 **/
public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode slow = head, fast = head;
		while (fast != null) {
			slow = slow.next;
			if (fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			if (fast == slow) {
				ListNode ptr = head;
				while (ptr != slow) {
					ptr = ptr.next;
					slow = slow.next;
				}
				return ptr;
			}
		}
		return null;
	}
}