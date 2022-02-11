package top.chenqwwq.leetcode.lcof._2021._57_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chen
 * @date 2021-05-31
 **/
public class Solution {
	public int[][] findContinuousSequence(int target) {
		List<int[]> ans = new ArrayList<>();
		int right = target / 2 + (target & 1), left = right - 1;
		while (left < right && left > 0) {
			double sum = (right + left) * (right - left + 1) / 2d;
			if (sum == target) {
				int[] tmp = new int[right - left + 1];
				for (int i = left; i <= right; i++) {
					tmp[i - left] = i;
				}
				ans.add(tmp);
				left--;
			} else if (sum > target) {
				right--;
			} else {
				left--;
			}
		}
		ans.sort(Comparator.comparingInt(a -> a[0]));
		return ans.toArray(new int[][]{});
	}
}