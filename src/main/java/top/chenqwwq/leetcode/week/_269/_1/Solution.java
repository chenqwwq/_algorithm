package top.chenqwwq.leetcode.week._269._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/11/28
 **/
public class Solution {
	public List<Integer> targetIndices(int[] nums, int target) {
		final int n = nums.length;
		Arrays.sort(nums);
		final List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] == target) {
				while (i < n && nums[i] == target) {
					ans.add(i++);
				}
				break;
			}
		}
		return ans;
	}
}