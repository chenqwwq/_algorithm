package top.chenqwwq.leetcode.archive.lcof2._29_$;

import top.chenqwwq.leetcode.common.Node;


/**
 * @author chenbingxin
 * @date 2021/12/20
 **/
class Solution {
	public Node insert(Node head, int insertVal) {
		if (head == null) {
			Node node = new Node(insertVal);
			node.next = node;
			return node;
		}
		Node max = head, min = head;
		Node p = head.next;
		while (p != head) {
			if (p.val > max.val) {
				max = p;
			}
			if (p.val < min.val) {
				min = p;
			}
			p = p.next;
		}
		if (max == min) {
			max.next = new Node(insertVal, max.next);
		} else if (insertVal >= max.val || insertVal <= min.val) {
			while (max.next.val == max.val) {
				max = max.next;
			}
			max.next = new Node(insertVal, max.next);
		} else {
			while (min.next.val < insertVal) {
				min = min.next;
			}
			min.next = new Node(insertVal, min.next);
		}
		return head;
	}
}