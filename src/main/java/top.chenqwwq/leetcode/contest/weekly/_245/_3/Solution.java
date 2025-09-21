package top.chenqwwq.leetcode.contest.weekly._245._3;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/6/13
 **/
public class Solution {
	public boolean mergeTriplets(int[][] triplets, int[] target) {
		final int n = triplets.length;
		int[] num1 = new int[n], num2 = new int[n], num3 = new int[n];
		for (int i = 0; i < n; i++) {
			if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
				continue;
			}
			num1[i] = triplets[i][0];
			num2[i] = triplets[i][1];
			num3[i] = triplets[i][2];
			if (num1[i] == target[0] && num2[i] == target[1] && num3[i] == target[2]) {
				return true;
			}
		}
		Arrays.sort(num1);
		Arrays.sort(num2);
		Arrays.sort(num3);
		for (int i = 0; i < n; i++) {
			if (num1[i] == target[0] && num2[i] == target[1] && num3[i] == target[2]) {
				return true;
			}
		}
		return false;
	}
}