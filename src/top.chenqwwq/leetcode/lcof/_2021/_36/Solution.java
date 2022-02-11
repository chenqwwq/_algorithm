package top.chenqwwq.leetcode.lcof._2021._36;

/**
 * @author chen
 * @date 2021/7/3
 **/
public class Solution {
	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}

		// 获取尾节点
		final Node dfs = dfs(root);

		// 头尾连接
		dfs.right = head;
		head.left = dfs;

		return head;
	}

	Node head;

	public Node dfs(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		// 存在左节点
		if (root.left != null) {
			final Node node = dfs(root.left);
			// 找到最左边的节点
			if (head == null) {
				head = node;
			}
			node.right = root;
			root.left = node;
		}
		if (head == null) {
			head = root;
		}
		if (root.right == null) {
			return root;
		}
		final Node dfs = dfs(root.right);
		root.right.left = root;
		return dfs;
	}
}


class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
};