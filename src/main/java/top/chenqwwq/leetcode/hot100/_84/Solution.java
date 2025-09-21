package top.chenqwwq.leetcode.hot100._84;

/**
 * @author chen
 * @date 2021-09-01
 **/
public class Solution {
	public int largestRectangleArea(int[] heights) {
		final int n = heights.length;
		// 数组前后哨兵
		final int[] nums = new int[n + 2];
		System.arraycopy(heights, 0, nums, 1, n);
		// 使用数组模拟栈,维护一个绝对递增的单调栈,栈顶为最大值
		int[] stack = new int[n + 2];
		int ans = 0, top = 0;
		for (int i = 1; i < n + 2; i++) {
			while (nums[stack[top]] > nums[i]) {
				// 矩形面积不能是top到i
				// 0,1，4，3，2，3,0
				// 最后的栈 0,1,2,3
				// 计算2的时候还要包括4,3中的面积,单调栈的规则保证保证了2的右边到1的中间全大于2
				ans = Math.max(nums[stack[top--]] * (i - stack[top] - 1), ans);
			}
			stack[++top] = i;
		}
		return ans;
	}
}