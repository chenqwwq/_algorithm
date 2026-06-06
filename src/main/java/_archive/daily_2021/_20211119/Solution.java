package top.chenqwwq.leetcode.daily._2021._20211119;

/**
 * @author chen
 * @date 2021-11-19
 **/
public class Solution {
	public int integerReplacement(int n) {
		if (n == 1) {
			return 0;
		}
		if ((n & 1) == 0) {
			return 1 + integerReplacement(n / 2);
		}
		// n 可能越界
		return 2 + Math.min(integerReplacement((n - 1) / 2), integerReplacement(n / 2));
	}
}