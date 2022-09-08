package top.chenqwwq.leetcode.archive.lcof2._27;

import top.chenqwwq.leetcode.common.ListNode;

import java.util.Stack;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Solution {
	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode node = head;
		while (node != null) {
			stack.add(node);
			node = node.next;
		}
		int cnt = stack.size() / 2;
		while (cnt-- > 0) {
			final ListNode pop = stack.pop();
			if(head.val != pop.val){
				return false;
			}
			head = head.next;
		}

		return true;
	}
}