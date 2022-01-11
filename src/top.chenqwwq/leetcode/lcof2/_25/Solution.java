package top.chenqwwq.leetcode.lcof2._25;

import sun.tools.jstack.JStack;
import top.chenqwwq.leetcode.common.ListNode;

import java.util.Stack;

/**
 * @author chenbingxin
 * @date 2021/12/14
 **/
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		Stack<ListNode> s1 = new Stack<>(), s2 = new Stack<>();
		ListNode fake = l1;
		while (fake != null) {
			s1.push(fake);
			fake = fake.next;
		}
		fake = l2;
		while (fake != null) {
			s2.push(fake);
			fake = fake.next;
		}

		int carry = 0;
		ListNode node = null;
		while (!s1.isEmpty() && !s2.isEmpty()) {
			int tmp = s1.pop().val + s2.pop().val + carry;
			carry = tmp / 10;
			node = new ListNode(tmp % 10, node);
		}
		while (!s1.isEmpty()){
			int tmp = s1.pop().val + carry;
			carry = tmp / 10;
			node = new ListNode(tmp % 10,node);
		}
		while (!s2.isEmpty()){
			int tmp = s2.pop().val + carry;
			carry = tmp / 10;
			node = new ListNode(tmp % 10,node);
		}
		if(carry != 0){
			node = new ListNode(carry,node);
		}
		return node;
	}
}