package top.chenqwwq.leetcode.daily._20210531;

/**
 * @author chen
 * @date 2021/5/31
 **/
public class Solution {
	public boolean isPowerOfFour(int n) {
		return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
	}
}