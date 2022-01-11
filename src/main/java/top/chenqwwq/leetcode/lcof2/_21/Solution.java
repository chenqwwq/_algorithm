package top.chenqwwq.leetcode.lcof2._21;

import top.chenqwwq.leetcode.common.ListNode;

import java.sql.PreparedStatement;

/**
 * @author chenbingxin
 * @date 2021/12/13
 **/
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode fast = head, slow = head;
		while (n-- > 0 && fast != null) {
			fast = fast.next;
		}
		if (fast == null) {
			return head.next;
		}
		fast = fast.next;
		while (fast != null && slow != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		new Solution().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 4);
	}
}