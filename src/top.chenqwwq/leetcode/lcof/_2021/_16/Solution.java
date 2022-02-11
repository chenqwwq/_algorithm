package top.chenqwwq.leetcode.lcof._2021._16;

/**
 * @author chen
 * @date 2021/6/3
 **/
public class Solution {
	public double myPow(double x, int n) {
		// 快速幂实现
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n == -1) {
			return 1 / x;
		}
		double half = myPow(x, n / 2);
		double left = myPow(x, n % 2);
		return half * half * left;
	}
}