package top.chenqwwq.leetcode.biweek._63._1;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021-10-19
 **/
public class Solution {
	public int minMovesToSeat(int[] seats, int[] students) {
		Arrays.sort(seats);
		Arrays.sort(students);
		int sum = 0;
		final int n = seats.length;
		for (int i = 0; i < n; i++) {
			sum += Math.abs(seats[i] - students[i]);
		}
		return sum;
	}
}