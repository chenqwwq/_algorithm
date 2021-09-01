package top.chenqwwq.leetcode.hot100._84;

import java.util.Stack;

/**
 * @author chen
 * @date 2021-09-01
 **/
public class Solution {
	public int largestRectangleArea(int[] heights) {
		final int n = heights.length;
		// 维护一个递增的单调栈,栈顶为最大值
		// 绝对递增，不能
		Stack<Integer> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, heights[i]);
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				// 求出矩形面积
				final Integer idx = stack.pop();
				int area = (i - idx + 1) * heights[i];
				ans = Math.max(area, ans);
				int left = 0;
				while (!stack.isEmpty() && heights[stack.peek()] == heights[idx]){
					
				}
				if (!stack.isEmpty()) {
					// 处理高度相同的情况
					ans = Math.max(ans, heights[stack.peek()] * (idx - stack.peek() + 1));
				}
			}
			stack.push(i);
		}
		while (stack.size() > 1) {
			final Integer pop = stack.pop(), peek = stack.peek();
			ans = Math.max(ans, heights[peek] * (pop - peek + 1));
		}
		return ans;
	}
}