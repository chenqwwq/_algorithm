package top.chenqwwq.leetcode.topic.greedy._11;

/**
 * @author chen
 * @date 2021-10-22
 **/
public class Solution {
	int[] height;

	public int maxArea(int[] _height) {
		this.height = _height;

		final int n = height.length;
		int left = 0, right = n - 1, ans = 0;
		while (left < right) {
			ans = Math.max(ans, getArea(left, right));
			if (height[left] <= height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return ans;
	}

	private int getArea(int l, int r) {
		return (r - l) * Math.min(height[l], height[r]);
	}
}