package top.chenqwwq.leetcode.daily._2021._20211112;

/**
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 11
 *
 * @author chen
 * @date 2021-11-12
 **/
public class Solution {

	private static final int INF = 0x3f3f3f3f;
	private static final int[][] cache = new int[201][201];

	public int getMoneyAmount(int n) {
		if (n <= 2) {
			return n - 1;
		}
		return dfs(0, n);
	}

	public int dfs(int l, int r) {
		if (l >= r) {
			return 0;
		}
		if (cache[l][r] != 0) {
			return cache[l][r];
		}

		// 遍历可能的值
		int ans = INF;
		for (int i = l; i <= r; i++) {
			ans = Math.min(ans, Math.max(dfs(l, i - 1), dfs(i + 1, r)) + i);
		}
		cache[l][r] = ans;
		return ans;
	}
}