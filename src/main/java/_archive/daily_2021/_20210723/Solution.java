package top.chenqwwq.leetcode.daily._2021._20210723;

/**
 * 1893. Check if All the Integers in a Range Are Covered
 * You are given a 2D integer array ranges and two integers left and right. Each ranges[i] = [starti, endi] represents an inclusive interval between starti and endi.
 * <p>
 * Return true if each integer in the inclusive range [left, right] is covered by at least one interval in ranges. Return false otherwise.
 * <p>
 * An integer x is covered by an interval ranges[i] = [starti, endi] if starti <= x <= endi.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * Output: true
 * Explanation: Every integer between 2 and 5 is covered:
 * - 2 is covered by the first range.
 * - 3 and 4 are covered by the second range.
 * - 5 is covered by the third range.
 * Example 2:
 * <p>
 * Input: ranges = [[1,10],[10,20]], left = 21, right = 21
 * Output: false
 * Explanation: 21 is not covered by any range.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 *
 * @author chen
 * @date 2021-07-23
 **/
public class Solution {
	public boolean isCovered(int[][] ranges, int left, int right) {
		int cnt = right - left + 1;
		boolean[] visit = new boolean[51];
		while (left <= right) {
			visit[left++] = true;
		}

		for (int[] nums : ranges) {
			int cur = nums[0];
			while (cur <= nums[1]) {
				if (visit[cur]) {
					if (--cnt == 0) {
						return true;
					}
					visit[cur] = false;
				}
				cur++;
			}
		}
		return cnt == 0;
	}
}