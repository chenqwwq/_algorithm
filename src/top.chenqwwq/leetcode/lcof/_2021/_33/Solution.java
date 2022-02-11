package top.chenqwwq.leetcode.lcof._2021._33;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 *
 * @author chen
 * @date 2021/7/17
 **/
public class Solution {
	public boolean verifyPostorder(int[] postorder) {
		// 后续遍历,所以前面的数组可以分为两部分，一部分比他小，一部分比他大
		return verify(postorder, 0, postorder.length - 1, Integer.MAX_VALUE);
	}

	public boolean verify(int[] nums, int left, int right, int num) {
		if (left >= right) {
			return true;
		}
		int target = nums[right], idx = right - 1;
		// 向左找到第一个比他小的
		while (idx >= left) {
			if (nums[idx] >= num) {
				return false;
			}
			if (nums[idx] < target) {
				break;
			}
			idx--;
		}
		return verify(nums, left, idx, target) && verify(nums, idx + 1, right - 1, Integer.MAX_VALUE);
	}
}