package top.chenqwwq.leetcode.lcof._2021._13;

/**
 * @author chen
 * @date 2021/6/2
 **/
public class Solution {
	public int movingCount(int m, int n, int k) {
		return dfs(m, n, 0, 0, k, new boolean[m][n]);
	}

	public int dfs(int m, int n, int x, int y, int k, boolean[][] visit) {
		// 原来是上下左右都可以,转成下和右的
		if (x >= m || y >= n || visit[x][y]) {
			return 0;
		}
		visit[x][y] = true;
		if (getNum(x) + getNum(y) > k) {
			return 0;
		}

		return 1 + dfs(m, n, x + 1, y, k, visit) + dfs(m, n, x, y + 1, k, visit);
	}

	public int getNum(int n) {
		int ans = 0;
		while (n != 0) {
			ans += n % 10;
			n /= 10;
		}
		return ans;
	}

}