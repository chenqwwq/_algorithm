package top.chenqwwq.leetcode.lcof._2021._35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021-07-02
 **/
public class Solution {
	/**
	 * 建立 Node 和 Node 的隐射关系
	 */
	Map<Node, Node> hash = new HashMap<>();

	public Node copyRandomList(Node head) {
		Node fake = new Node(-1);
		Node fh = fake;
		while (head != null) {
			final Node node = getOrCreate(head);
			if (head.random != null) {
				node.random = getOrCreate(head.random);
			}
			fh.next = node;
			fh = fh.next;
			head = head.next;
		}
		return fake.next;
	}

	public Node getOrCreate(Node node) {
		if (hash.containsKey(node)) {
			return hash.get(node);
		}
		final Node newNode = new Node(node.val);
		hash.put(node, newNode);
		return newNode;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	public Node(int val, Node next, Node random) {
		this.val = val;
		this.next = next;
		this.random = random;
	}
}