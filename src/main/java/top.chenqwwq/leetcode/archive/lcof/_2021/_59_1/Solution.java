package top.chenqwwq.leetcode.archive.lcof._2021._59_1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * @author chen
 * @date 2021-07-27
 **/
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		final int n = nums.length;
		if (n == 0) {
			return new int[]{};
		}

		// 单调队列
		final int[] ans = new int[n - k + 1];
		Deque<Integer> stack = new LinkedList<>();
		int l = 0, r = 0;
		while (r < n) {
			// 当前数字入队列,后入时弹出所有小于它的数字
			while (!stack.isEmpty() && stack.peekLast() < nums[r]) {
				stack.pollLast();
			}
			stack.addLast(nums[r++]);
			if (r - l < k) {
				continue;
			}
			ans[l] = stack.peekFirst();
			if (nums[l++] >= stack.peekFirst()) {
				stack.pollFirst();
			}
		}

		return ans;
	}
}