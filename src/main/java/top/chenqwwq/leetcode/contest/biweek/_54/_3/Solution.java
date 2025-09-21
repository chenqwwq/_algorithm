package top.chenqwwq.leetcode.contest.biweek._54._3;


/**
 * @author chen
 * @date 2021/6/12
 **/
public class Solution {
	public boolean isCovered(int[][] ranges, int left, int right) {
		boolean[] hash = new boolean[51];
		for (int[] arr : ranges) {
			for (int i = arr[0]; i <= arr[1]; i++) {
				hash[i] = true;
			}
		}
		for (int i = left; i <= right; i++) {
			if (!hash[i]) {
				return false;
			}
		}
		return true;
	}
}