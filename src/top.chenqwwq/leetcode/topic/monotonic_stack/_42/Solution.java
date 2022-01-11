package top.chenqwwq.leetcode.topic.monotonic_stack._42;

import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 *
 * @author chen
 * @date 2021/7/3
 **/
public class Solution {

	Stack<Integer> stack = new Stack<>();

	public int trap(int[] height) {
		final int n = height.length;
		if (n < 3) {
			return 0;
		}
		stack.add(height[0]);
		stack.add(height[1]);

		int i = 2, tmp = 0;
		int ans = 0;
		while (i < n) {
			final int size = stack.peek() - height[i];
			if (size > 0) {
				tmp += size;
			} else {
				ans += tmp;
				while (!stack.isEmpty() && stack.peek() < height[i]) {
					stack.pop();
				}
				stack.add(height[i]);
			}
			i++;
		}
		return ans;
	}
}