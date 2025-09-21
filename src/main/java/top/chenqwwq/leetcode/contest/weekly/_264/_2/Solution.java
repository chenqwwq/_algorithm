package top.chenqwwq.leetcode.contest.weekly._264._2;

/**
 * @author chen
 * @date 2021/10/24
 **/
public class Solution {
	public boolean check(int num) {
		int[] xf = new int[10];
		while (num != 0) {
			int x = num % 10;
			xf[x]++;
			num /= 10;
		}

		for (int x = 0; x < 10; x++) {
			if (xf[x] != 0 && x != xf[x]) {
				return false;
			}
		}
		return true;
	}

	public int nextBeautifulNumber(int n) {
		int num = n + 1;
		while (!check(num)) {
			num++;
		}
		return num;
	}
}