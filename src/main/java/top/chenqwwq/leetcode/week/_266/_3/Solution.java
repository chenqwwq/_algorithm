package top.chenqwwq.leetcode.week._266._3;

/**
 * @author chen
 * @date 2021-11-19
 **/
public class Solution {
	int[] quantities;
	int n;

	public int minimizedMaximum(int _n, int[] _quantities) {
		this.quantities = _quantities;
		this.n = _n;
		int r = 0;
		for (int num : quantities) {
			r = Math.max(r, num);
		}
		final int m = quantities.length;
		if (n <= m) {
			return r;
		}
		int l = 1;
		while (l < r) {
			final int mid = (l + r) >> 1;
			if (isOk(mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}

	public boolean isOk(int max) {
		int cnt = 0;
		for (int num : quantities) {
			cnt += num / max + (num % max == 0 ? 0 : 1);
		}
		return cnt <= n;
	}
}
