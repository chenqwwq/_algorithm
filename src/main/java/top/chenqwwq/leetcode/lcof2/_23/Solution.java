package top.chenqwwq.leetcode.lcof2._23;

import top.chenqwwq.leetcode.common.ListNode;

import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/14
 **/
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode n1 = headA, n2 = headB;
		while (n1 != null && n2 != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		ListNode fast, slow;
		if (n1 != null) {
			fast = headA;
			slow = headB;
			while (n1 != null) {
				n1 = n1.next;
				fast = fast.next;
			}
		} else {
			fast = headB;
			slow = headA;
			while (n2 != null) {
				fast = fast.next;
				n2 = n2.next;
			}
		}

		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}