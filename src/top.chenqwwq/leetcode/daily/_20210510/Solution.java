package top.chenqwwq.leetcode.daily._20210510;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 * <p>
 * Input: root1 = [1], root2 = [1]
 * Output: true
 * Example 3:
 * <p>
 * Input: root1 = [1], root2 = [2]
 * Output: false
 * Example 4:
 * <p>
 * Input: root1 = [1,2], root2 = [2,2]
 * Output: true
 * Example 5:
 * <p>
 * <p>
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 *
 * @author chen
 * @date 2021/5/10
 **/
public class Solution {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaf1 = new ArrayList<>();
		List<Integer> leaf2 = new ArrayList<>();

		getLeaf(root1, leaf1);
		getLeaf(root2, leaf2);

		if (leaf1.size() != leaf2.size()) {
			return false;
		}

		for (int i = 0; i < leaf1.size(); i++) {
			if (!leaf1.get(i).equals(leaf2.get(i))) {
				return false;
			}
		}
		return true;
	}


	public void getLeaf(TreeNode root, List<Integer> leaf) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			leaf.add(root.val);
		}

		getLeaf(root.left, leaf);
		getLeaf(root.right, leaf);
	}

}























