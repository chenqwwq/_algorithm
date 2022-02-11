package top.chenqwwq.leetcode.weekly._248._3;

/**
 * @author chen
 * @date 2021/7/4
 **/
public class Solution {
	private int b = 1000000007;

	public int countGoodNumbers(long n) {
		// even 偶数位 odd 技术位
		long odd = n / 2, even = n - n / 2;
		return (int) (fastPower(5, even) * fastPower(4, odd) % b);
	}

	public long fastPower(int a, long n) {
		if (n == 0) {
			return 1 % b;
		}
		long ans = 1L;
		long base = a % b;
		while (n != 0) {
			if ((n & 1) == 1) {
				ans = (ans * base) % b;
			}
			//为了避免超出long的范围，所以取三次模
			base = (base % b) * (base % b) % b;
			n >>= 1;
		}
		return ans;
	}
}