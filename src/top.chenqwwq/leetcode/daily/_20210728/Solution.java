package top.chenqwwq.leetcode.daily._20210728;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 863. All Nodes Distance K in Binary Tree
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Example 2:
 * <p>
 * Input: root = [1], target = 1, k = 3
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 *
 * @author chen
 * @date 2021-07-28
 **/
public class Solution {
	List<Integer> ans = new ArrayList<>();

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		dfs(root, target, k);
		return ans;
	}

	public int dfs(TreeNode node, TreeNode target, int k) {
		if (node == null) {
			return -1;
		}
		if (target == null) {
			if (k == 0) {
				ans.add(node.val);
				return -1;
			}
			dfs(node.left, null, k - 1);
			dfs(node.right, null, k - 1);
			return -1;
		}
		if (node.val == target.val) {
			if (k == 0) {
				ans.add(node.val);
				return -1;
			}
			final int k1 = k - 1;
			dfs(node.left, null, k1);
			dfs(node.right, null, k1);
			return k1;
		}
		final int dfs = dfs(node.left, target, k);
		if (dfs == 0) {
			ans.add(node.val);
			return -1;
		} else if (dfs > 0) {
			dfs(node.right, null, dfs - 1);
			return dfs - 1;
		}
		final int dfs1 = dfs(node.right, target, k);
		if (dfs1 == 0) {
			ans.add(node.val);
			return -1;
		} else if (dfs1 > 0) {
			dfs(node.left, null, dfs1 - 1);
			return dfs1 - 1;
		}
		return -1;
	}
}