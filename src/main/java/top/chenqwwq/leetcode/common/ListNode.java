package top.chenqwwq.leetcode.common;

/**
 * @author chen
 * @date 2020/5/16 下午3:36
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public ListNode(int x, ListNode node) {
		val = x;
		this.next = node;
	}

	public static ListNode build(int...nums) {
		ListNode fake = new ListNode(-1), node = fake;
		for (int num : nums) {
			final ListNode next = new ListNode(num);
			node.next = next;
			node = next;
		}
		return fake.next;
	}
}
