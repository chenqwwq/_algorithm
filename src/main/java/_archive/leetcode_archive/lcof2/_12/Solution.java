package top.chenqwwq.leetcode.archive.lcof2._12;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class Solution {
	public int pivotIndex(int[] nums) {
		// 前缀和简单应用
		final int n = nums.length;
		final int[] sum = new int[n + 1];

		for (int i = 0; i < n; i++) {
			sum[i + 1] = sum[i] + nums[i];
		}

		for (int i = 1; i <= n; i++) {
			if(sum[i-1] - sum[0] == sum[n] - sum[i]){
				return i-1;
			}
		}
		return -1;
	}
}