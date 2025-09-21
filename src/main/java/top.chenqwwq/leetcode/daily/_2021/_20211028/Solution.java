package top.chenqwwq.leetcode.daily._2021._20211028;

/**
 * @author chen
 * @date 2021-10-28
 **/
public class Solution {
	public boolean reorderedPowerOf2(int n) {
		final int[] freq = getFreq(n);

		int base = 1;
		do {
			if (eq(getFreq(base), freq)) {
				return true;
			}
			base <<= 1;
		} while (base <= Math.pow(10, 9));
		return false;
	}

	private boolean eq(int[] a, int[] b) {
		for (int i = 0; i < 10; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	private int[] getFreq(int n) {
		// 0 ~ 9 的词频率
		int[] freq = new int[10];
		while (n != 0) {
			freq[n % 10]++;
			n /= 10;
		}
		return freq;
	}
}