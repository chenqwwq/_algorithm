package top.chenqwwq.leetcode.daily._20211205;

/**
 * @author chenbingxin
 * @date 2021/12/5
 **/
public class Solution {

	private static final int MOD = 1337;

	public int superPow(int a, int[] b) {
		return superPow(a, b, b.length - 1);
	}

	public int superPow(int a, int[] b, int idx) {
		if (idx < 0) {
			return -1;
		}
		return pow(superPow(a, b, idx - 1), 10) * pow(a, b[idx]) % MOD;
	}

	public int pow(int a, int b) {
		int ans = 1;
		a %= 1337;
		while (b > 0){
			if((b & 1) != 0){
				ans = ans * a % MOD;
			}
			a = a * a % MOD;
			b >>= 1;
		}
		return ans;
	}
}