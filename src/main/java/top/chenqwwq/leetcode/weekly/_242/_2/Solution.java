package top.chenqwwq.leetcode.weekly._242._2;

/**
 * @author chen
 * @date 2021/5/23
 **/
public class Solution {
	public int minSpeedOnTime(int[] dist, double hour) {
		if (dist.length - 1 > hour) {
			return -1;
		}
		int left = 1, right = 10000000;

		while (left <= right) {
			int mid = (left + right) >> 1;
			final double check = check(dist, mid);
			if (check > hour) {
				left = mid + 1;
			} else if (check < hour) {
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return left;
	}

	public double check(int[] dist, int speed) {
		double sum = 0;
		for (int i = 0; i < dist.length - 1; i++) {
			sum += getInt(1.0d * dist[i] / speed);
		}
		return sum + 1.0d * dist[dist.length - 1] / speed;
	}

	private int getInt(double num) {
		if (num % 1 != 0) {
			return (int) num + 1;
		}
		return (int) num;
	}
}