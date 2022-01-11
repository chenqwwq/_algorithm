package top.chenqwwq.leetcode.daily._20210630;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * @author chen
 * @date 2021-06-30
 **/
public class Codec {

	private static final TreeNode NULL_NODE = new TreeNode(Integer.MIN_VALUE);

	public static void main(String[] args) {
		final Codec codec = new Codec();
		final String serialize = codec.serialize(new TreeNode(1, new TreeNode(2, null, null), null));
		System.out.println(serialize);
		final TreeNode deserialize = codec.deserialize(serialize);
		System.out.println(deserialize);
	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			final TreeNode poll = queue.poll();
			sb.append(",").append(poll.val);
			if (poll != NULL_NODE) {
				queue.add(poll.left == null ? NULL_NODE : poll.left);
				queue.add(poll.right == null ? NULL_NODE : poll.right);
			}
		}
		return sb.substring(1);
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		final String[] split = data.split(",");
		TreeNode root = new TreeNode(Integer.valueOf(split[0]));
		int i = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty() && i < split.length) {
			final TreeNode poll = queue.poll();
			final int num1 = Integer.parseInt(split[i++]);
			if (num1 != Integer.MIN_VALUE) {
				final TreeNode left = new TreeNode(num1);
				poll.left = left;
				queue.add(left);
			}
			final int num2 = Integer.parseInt(split[i++]);
			if (num2 != Integer.MIN_VALUE) {
				final TreeNode right = new TreeNode(num2);
				poll.right = right;
				queue.add(right);
			}
		}
		return root;
	}
}