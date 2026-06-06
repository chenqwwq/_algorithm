package top.chenqwwq.leetcode.contest.weekly._254._3;

/**
 * @author chen
 * @date 2021/8/15
 **/
public class Solution {
	private static final int mod = (int) 1e9 + 7;

	public int minNonZeroProduct(int p) {
		if (p == 1) {
			return 1;
		}
		if (p == 2) {
			return 6;
		}
		long max = fastPower(2, p, Long.MAX_VALUE) - 1;
		return (int) ((max % mod) * fastPower((max - 1) % mod, max / 2, mod) % mod);

	}

	public long fastPower(long a, long b, long mod) {
		long ans = 1;
		long base = a;
		while (b != 0) {
			if ((b & 1) != 0) { //如果当前的次幂数最后一位(二进制数)不为0的话，那么我们将当前权值加入到最后答案里面去
				ans = (ans * base % mod);
			}
			//权值增加
			base = base * base % mod;
			b >>= 1;
		}
		return ans;
	}
}
