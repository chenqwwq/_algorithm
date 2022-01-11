package top.chenqwwq.leetcode.lcof._2021._52;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chen
 * @date 2021-07-09
 **/
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int a = getLength(headA), b = getLength(headB);
		while (a - b > 0) {
			headA = headA.next;
			a--;
		}
		while (b - a > 0) {
			headB = headB.next;
			b--;
		}

		while (headA != null && headB != null) {
			if (headA == headB) {
				return headB;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	private int getLength(ListNode node) {
		int ans = 0;
		ListNode fake = node;
		while (fake != null) {
			ans++;
			fake = fake.next;
		}
		return ans;
	}
}