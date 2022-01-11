package top.chenqwwq.leetcode.daily._20210507;

/**
 * 1486. XOR Operation in an Array
 * Given an integer n and an integer start.
 * <p>
 * Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
 * <p>
 * Return the bitwise XOR of all elements of nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, start = 0
 * Output: 8
 * Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
 * Where "^" corresponds to bitwise XOR operator.
 * Example 2:
 * <p>
 * Input: n = 4, start = 3
 * Output: 8
 * Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
 * Example 3:
 * <p>
 * Input: n = 1, start = 7
 * Output: 7
 * Example 4:
 * <p>
 * Input: n = 10, start = 5
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 *
 * @author chen
 * @date 2021-05-07
 **/
public class Solution {
	public int xorOperation(int n, int start) {
		int ans = start;
		for (int i = 1; i < n; i++) {
			ans ^= (start + 2 * i);
		}
		return ans;
	}
}