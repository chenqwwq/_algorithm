package top.chenqwwq.leetcode.lcof._2021._6;

import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import top.chenqwwq.leetcode.common.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {
	public int[] reversePrint(ListNode head) {
		// 翻转链表,记录列表大小在输出

		if (head == null) {
			return new int[]{};
		}
		if (head.next == null) {
			return new int[]{head.val};
		}

		ListNode pre = head, curr = head.next;
		head.next = null;
		int size = 1;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
			size++;
		}

		int[] ans = new int[size];
		int idx = 0;
		while (pre != null) {
			ans[idx++] = pre.val;
			pre = pre.next;
		}
		return ans;
	}
}