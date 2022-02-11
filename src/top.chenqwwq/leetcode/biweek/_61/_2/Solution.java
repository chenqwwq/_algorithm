package top.chenqwwq.leetcode.biweek._61._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021/9/18
 **/
public class Solution {
	public long maxTaxiEarnings(int n, int[][] rides) {
		// dp[i] 表示最终位置为0的收益
		long[] dp = new long[n + 1];
		Map<Integer, List<int[]>> rideMap = new HashMap<>();
		for (int[] ride : rides) {
			final List<int[]> orDefault = rideMap.getOrDefault(ride[1], new ArrayList<>());
			orDefault.add(new int[]{ride[0], ride[2] + ride[1] - ride[0]});
			rideMap.put(ride[1], orDefault);
		}

		long ans = 0;
		for (int i = 1; i <= n; i++) {
			final List<int[]> allRides = rideMap.get(i);
			if (allRides == null) {
				dp[i] = dp[i - 1];
				continue;
			}
			long max = -1;
			for (int[] ride : allRides) {
				max = Math.max(max, dp[ride[0]] + ride[1]);
			}
			dp[i] = Math.max(max, dp[i - 1]);
			ans = Math.max(max, dp[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().maxTaxiEarnings(10, new int[][]{
				{9, 10, 2}, {4, 5, 6}, {6, 8, 1}, {1, 5, 5}, {4, 9, 5}, {1, 6, 5}, {4, 8, 3}, {4, 7, 10}, {1, 9, 8}, {2, 3, 5}
		});
//		new Solution().maxTaxiEarnings(5, new int[][]{
//				{2, 5, 4},
//				{1, 5, 1}
//		});
	}
}