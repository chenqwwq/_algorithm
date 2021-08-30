package top.chenqwwq.面试._1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/8/29
 **/
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String[] firstLine = reader.readLine().split(" ");
		final int n = Integer.parseInt(firstLine[0]), m = Integer.parseInt(firstLine[1]);
		final int k = Integer.parseInt(reader.readLine());
		int[][] plan = new int[k][3];
		for (int i = 0; i < k; i++) {
			final String[] line = reader.readLine().split(" ");
			plan[i] = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])};
		}

		int ans = 0;
		// 枚举每个单元格
		for (int i = 0; i < m; i++) {
			inner:
			for (int j = 0; j < n; j++) {
				// 从后遍历是否被修改过
				for (int q = k - 1; q >= 0; q--) {
					if (valid(plan[q][0], plan[q][1], plan[q][2], i, j)) {
						ans += k - q + 1;
						break inner;
					}
				}
				ans += k + 1;
			}
		}
		System.out.println(ans);
	}

	public static boolean valid(int x, int y, int r, int i, int j) {
		return (i - x) * (i - x) + (j - y) * (j - y) <= r * r;
	}
}
