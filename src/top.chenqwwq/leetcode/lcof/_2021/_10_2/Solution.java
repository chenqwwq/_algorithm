package top.chenqwwq.leetcode.lcof._2021._10_2;

/**
 * @author chen
 * @date 2021/5/29
 **/
public class Solution {

	static final int MOD = 1000000007;

	public int numWays(int n) {
		if (n < 2) {
			return 1;
		}
		int x = 1, y = 1;
		for (int i = 2; i <= n; i++) {
			int tmp = (x + y) % MOD;
			x = y;
			y = tmp;
		}
		return y;
	}
}