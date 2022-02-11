package top.chenqwwq.leetcode.lcof2._1;

/**
 * @author chenbingxin
 * @date 2021/12/3
 **/
public class Solution {
	public int divide(int _a, int _b) {
		// a / b
		// 借鉴快速幂的形式

		long a = _a,b = _b;
		boolean positive = (_a > 0 && _b > 0) || (_a < 0 && _b < 0);
		a = Math.abs(a);
		b = Math.abs(b);

		long ans = 0;
		while (b <= a){
			long level = 1, base = b;
			while (base << 1 < a){
				level <<= 1;
				base <<= 1;
			}
			ans += level;
			a -= base;
		}

		ans = positive ? ans : -ans;

		return ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE ? Integer.MAX_VALUE : (int) ans;
	}
}