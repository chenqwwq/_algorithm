package top.chenqwwq.leetcode.lcof._2021._14_2;

/**
 * @author chen
 * @date 2021/6/2
 **/
public class Solution {

	private static final int MOD = 1000000007;

	public int cuttingRope(int n) {
		if (n <= 3) {
			return n - 1;
		}
		long ans = 1;
		while (n > 4) {
			ans = (ans *  3) % MOD;
			n -= 3;
		}
		return (int) (n > 1 ? (n * ans) % MOD : ans);
	}
}