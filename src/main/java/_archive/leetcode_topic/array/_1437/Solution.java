package top.chenqwwq.leetcode.topic.array._1437;

/**
 * @author chen
 * @date 2021-05-11
 **/
public class Solution {
	public boolean kLengthApart(int[] nums, int k) {
		for (int i = 0; i < nums.length; ) {
			if (nums[i] == 0) {
				++i;
				continue;
			}
			int target = Math.min(i + k + 1, nums.length);
			while (++i < target) {
				if (nums[i] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}