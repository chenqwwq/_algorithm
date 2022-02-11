package top.chenqwwq.leetcode.weekly._249._3;

/**
 * @author chen
 * @date 2021/7/11
 **/
public class Solution {
	public int colorTheGrid(int m, int n) {
		int[][] colour = new int[m][n];
		return dfs(colour, 0, 0, m, n);
	}

	public int dfs(int[][] colour, int x, int y, int m, int n) {
		if (x >= m || y >= n) {
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= 3; i++) {
			if ((x > 0 && colour[x - 1][y] == i) || (y > 0 && colour[x][y - 1] == i)) {
				continue;
			}
			colour[x][y] = i;
			int nextX = x + 1 == m ? 0 : x + 1, nextY = x + 1 == m ? y + 1 : y;
			ans += dfs(colour, nextX, nextY, m, n);
			colour[x][y] = 0;
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j < 15; j++) {
				System.out.print(solution.colorTheGrid(i, j) + "\t");
			}
			System.out.println();
		}
	}
}