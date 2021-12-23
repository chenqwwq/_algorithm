package top.chenqwwq.leetcode.weekly._270._3;

import top.chenqwwq.leetcode.common.TreeNode;

/**
 * @author chenbingxin
 * @date 2021/12/5
 **/
public class Solution {
	public String getDirections(TreeNode root, int startValue, int destValue) {
		if (root == null) {
			return null;
		}
		if (root.val == startValue) {
			String path = getDirections(root.left, -1, destValue);
			if (path != null) {
				return "L" + path;
			}
			path = getDirections(root.right, -1, destValue);
			if (path != null) {
				return "R" + path;
			}
			return "";
		} else if (root.val == destValue) {
			String path = getDirections(root.left, startValue, -1);
			if (path != null) {
				return path + 'U';
			}
			path = getDirections(root.right, startValue, -1);
			if (path != null) {
				return path + 'U';
			}
			return "";

		} else {
			// 可能在一边也可能在两边

			String directions = getDirections(root.left, startValue, destValue);
			if(directions != null && directions.length() > 0){
				return directions;
			}
			directions = getDirections(root.right,startValue,destValue);
			if(directions != null && directions.length() > 0){
				return directions;
			}

			String ans = "";

			String p1 = getDirections(root.left, startValue, -1);
			if (p1 != null) {
				ans = p1 + "U";

			} else {
				String p2 = getDirections(root.right, startValue, -1);
				if (p2 != null) {
					ans = p2 + "U";
				}
			}
			if("".equals(ans)){
				return null;
			}

			String p3 = getDirections(root.left, -1, destValue);
			if (p3 != null) {
				return ans + "L" + p3;
			} else {
				String p4 = getDirections(root.right, -1, destValue);
				if (p4 != null) {
					return ans + "R" + p4;
				}
			}

			return null;
		}
	}

	public static void main(String[] args) {
		final String directions1 = new Solution().getDirections(new TreeNode(5, new TreeNode(8), new TreeNode(3, null, new TreeNode(4, new TreeNode(7), new TreeNode(6)))), 4, 3);
		System.out.println(directions1);
		final String directions = new Solution().getDirections(new TreeNode(1, null, new TreeNode(10, new TreeNode(12, new TreeNode(4), new TreeNode(6)), new TreeNode(13, null, new TreeNode(15, new TreeNode(5), new TreeNode(11))))), 6, 15);
		System.out.println(directions);
	}
}