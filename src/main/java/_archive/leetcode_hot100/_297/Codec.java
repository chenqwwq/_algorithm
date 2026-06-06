package top.chenqwwq.leetcode.hot100._297;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author chen
 * @date 2021-09-02
 **/
public class Codec {

	private static final String INF = "null";

	public String serialize(TreeNode root) {
		Deque<TreeNode> deque = new LinkedList<>();
		deque.offer(root);
		StringBuilder data = new StringBuilder();
		while (!deque.isEmpty()) {
			final TreeNode node = deque.pollFirst();
			if (Objects.isNull(node)) {
				data.append("#").append(INF);
			} else {
				data.append("#").append(node.val);
				deque.offerLast(node.left);
				deque.offerLast(node.right);
			}
		}
		return data.substring(1);
	}

	public TreeNode deserialize(String data) {
		final String[] values = data.split("#");
		if (Objects.equals(values[0], INF)) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		Deque<TreeNode> deque = new LinkedList<>();
		deque.push(root);
		int i = 1;
		while (!deque.isEmpty()) {
			final TreeNode node = deque.pollFirst();
			if (!Objects.equals(values[i], INF)) {
				final TreeNode left = new TreeNode(Integer.parseInt(values[i]));
				node.left = left;
				deque.addLast(left);
			}
			if (!Objects.equals(values[++i], INF)) {
				final TreeNode right = new TreeNode(Integer.parseInt(values[i]));
				node.right = right;
				deque.addLast(right);
			}
			i++;
		}

		return root;
	}
}