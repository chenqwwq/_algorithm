package top.chenqwwq.leetcode.daily._20210928;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author  chenqwwq
 */
public class Solution {
	public int pathSum(TreeNode root, int targetSum) {
		if(root == null){
			return 0;
		}
		return rootSum(root,targetSum) + pathSum(root.right,targetSum) + pathSum(root.left,targetSum);
	}

	public int rootSum(TreeNode root,int target){
		if(root == null){
			return 0;
		}
		target -= root.val;
		return (target == 0 ? 1 : 0) + rootSum(root.left,target) + rootSum(root.right,target);
	}
}