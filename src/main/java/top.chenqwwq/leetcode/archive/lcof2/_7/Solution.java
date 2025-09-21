package top.chenqwwq.leetcode.archive.lcof2._7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);
		final int n = nums.length;
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			// 确定一个双指针找另外两个

			if (nums[i] > 0 || (i > 0 && nums[i] == nums[i - 1])) {
				continue;
			}
			int left = i + 1, right = n - 1;
			while (left < right) {
				final int total = nums[left] + nums[right] + nums[i];
				if (total == 0) {
					ans.add(Arrays.asList(nums[left], nums[right], nums[i]));
					left++;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
				}else if(total < 0){
					left++;
				}else{
					right--;
				}
			}
		}

		return ans;
	}
}