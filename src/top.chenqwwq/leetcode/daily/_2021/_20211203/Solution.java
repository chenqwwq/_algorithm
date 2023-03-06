package top.chenqwwq.leetcode.daily._2021._20211203;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/3
 **/
public class Solution {
	public int largestSumAfterKNegations(int[] nums, int k) {
		final int n = nums.length;
		if (n == 0) {
			return 0;
		}

		Arrays.sort(nums);
		int i = 0;
		while (i < n && nums[i] < 0 && k-- > 0) {
			nums[i++] *= -1;
		}
		if (k > 0 && (k & 1) == 1) {
			if (i < 1) {
				nums[0] *= -1;
			}else if(i >= n ){
				nums[n-1] *= -1;
			} else {
				nums[nums[i] < nums[i - 1] ? i : i - 1] *= -1;
			}
		}
		int ans = 0;
		for (int num : nums) {
			ans += num;
		}
		return ans;
	}
}