package top.chenqwwq.leetcode.weekly._253._4;

/**
 * @author chen
 * @date 2021/8/8
 **/
public class Solution {

	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		int length = 0;
		int[] dp = new int[obstacles.length];
		int[] result = new int[obstacles.length];
		for (int i = 0; i < obstacles.length; i++) {
			int left = 0, right = length;
			while (left < right) {
				int mid = (left + right) / 2;
				if (dp[mid] <= obstacles[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			dp[left] = obstacles[i];
			result[i] = left + 1;
			if (left == length) {
				length++;
			}
		}
		return result;
	}
}