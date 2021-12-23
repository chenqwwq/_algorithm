package top.chenqwwq.leetcode.weekly._262._1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/11/20
 **/
public class Solution {
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
		// 位运算表示存在的状态
		short[] stats = new short[101];
		for (int num : nums1) {
			stats[num] |= 1;
		}
		for (int num : nums2) {
			stats[num] |= 2;
		}
		for (int num : nums3) {
			stats[num] |= 4;
		}
		final List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < 101; i++) {
			// 3 5 6 7
			if (stats[i] >= 3 && stats[i] != 4) {
				ans.add(i);
			}
		}
		return ans;
	}
}