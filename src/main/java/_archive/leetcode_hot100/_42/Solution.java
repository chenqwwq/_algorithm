package top.chenqwwq.leetcode.hot100._42;

import java.util.Stack;

/**
 * @author chen
 * @date 2021-09-01
 **/
public class Solution {

	public int trap(int[] height) {
		// 单调栈 栈中保存的是元素的下标
		// 维护栈中元素整体递减
		final int n = height.length;
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				final Integer low = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				final Integer high = stack.peek();
				ans += (Math.min(height[high], height[i]) - height[low]) * (i - high - 1);
			}
			stack.push(i);
		}
		return ans;
	}
//	public int trap(int[] height) {
//		final int n = height.length;
//		int[] leftMax = new int[n], rightMax = new int[n];
//		leftMax[0] = height[0];
//		rightMax[n - 1] = height[n - 1];
//		for (int i = 1; i < n - 1; i++) {
//			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//			rightMax[n - i - 1] = Math.max(rightMax[n - i], height[n - 1 - i]);
//		}
//
//		int ans = 0;
//		for (int i = 1; i < n - 1; i++) {
//			ans += Math.min(leftMax[i], rightMax[i]) - height[i];
//		}
//		return ans;
//	}
}
