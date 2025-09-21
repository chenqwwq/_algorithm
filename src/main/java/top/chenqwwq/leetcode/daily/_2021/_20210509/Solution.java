package top.chenqwwq.leetcode.daily._2021._20210509;

/**
 * 1482. Minimum Number of Days to Make m Bouquets
 * Given an integer array bloomDay, an integer m and an integer k.
 * <p>
 * We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * <p>
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * <p>
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let's see what happened in the first three days. x means flower bloomed and _ means flower didn't bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 * Example 2:
 * <p>
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
 * Output: -1
 * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
 * Example 3:
 * <p>
 * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * Output: 12
 * Explanation: We need 2 bouquets each should have 3 flowers.
 * Here's the garden after the 7 and 12 days:
 * After day 7: [x, x, x, x, _, x, x]
 * We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
 * After day 12: [x, x, x, x, x, x, x]
 * It is obvious that we can make two bouquets in different ways.
 * Example 4:
 * <p>
 * Input: bloomDay = [1000000000,1000000000], m = 1, k = 1
 * Output: 1000000000
 * Explanation: You need to wait 1000000000 days to have a flower ready for a bouquet.
 * Example 5:
 * <p>
 * Input: bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 *
 * @author chen
 * @date 2021/5/9
 **/
public class Solution {
	public int minDays(int[] bloomDay, int m, int k) {
		if (bloomDay.length < m * k) {
			return -1;
		}

		// 因为 bloomyDay[i] 的大小范围，所以无法通过遍历天来实现
		int left = bloomDay[0], right = bloomDay[0];
		for (int i : bloomDay) {
			if (left > i) {
				left = i;
			} else if (right < i) {
				right = i;
			}
		}

		while (left < right) {
			final int mid = (left + right) >> 1;
			if (check(bloomDay, m, k, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return check(bloomDay, m, k, right) ? right : -1;
	}

	private boolean check(int[] bloomDay, int m, int k, int day) {
		int cnt = 0;
		for (int i : bloomDay) {
			if (i <= day) {
				if (++cnt == k) {
					m--;
					cnt = 0;
				}
			} else {
				cnt = 0;
			}
		}
		return m <= 0;
	}
}
























