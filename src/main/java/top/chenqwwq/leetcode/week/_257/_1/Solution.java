package top.chenqwwq.leetcode.week._257._1;

/**
 * @author chen
 * @date 2021/9/5
 **/
public class Solution {
	public int countQuadruplets(int[] nums) {
		final int n = nums.length;
		int ans = 0;
		for (int a = 0; a < n; a++) {
			for (int b = a + 1; b < n; b++) {
				for (int c = b + 1; c < n; c++) {
					int sum = nums[a] + nums[b] + nums[c];
					for (int d = c + 1; d < n; d++) {
						if (sum == nums[d]) {
							ans++;
						}
					}
				}
			}
		}
		return ans;
	}

}