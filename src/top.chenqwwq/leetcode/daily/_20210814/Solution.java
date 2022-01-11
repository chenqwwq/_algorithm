package top.chenqwwq.leetcode.daily._20210814;

import java.util.HashMap;
import java.util.Map;

/**
 * 1583. Count Unhappy Friends
 * You are given a list of preferences for n friends, where n is always even.
 * <p>
 * For each person i, preferences[i] contains a list of friends sorted in the order of preference. In other words, a friend earlier in the list is more preferred than a friend later in the list. Friends in each list are denoted by integers from 0 to n-1.
 * <p>
 * All the friends are divided into pairs. The pairings are given in a list pairs, where pairs[i] = [xi, yi] denotes xi is paired with yi and yi is paired with xi.
 * <p>
 * However, this pairing may cause some of the friends to be unhappy. A friend x is unhappy if x is paired with y and there exists a friend u who is paired with v but:
 * <p>
 * x prefers u over y, and
 * u prefers x over v.
 * Return the number of unhappy friends.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, preferences = [[1, 2, 3], [3, 2, 0], [3, 1, 0], [1, 2, 0]], pairs = [[0, 1], [2, 3]]
 * Output: 2
 * Explanation:
 * Friend 1 is unhappy because:
 * - 1 is paired with 0 but prefers 3 over 0, and
 * - 3 prefers 1 over 2.
 * Friend 3 is unhappy because:
 * - 3 is paired with 2 but prefers 1 over 2, and
 * - 1 prefers 3 over 0.
 * Friends 0 and 2 are happy.
 * Example 2:
 * <p>
 * Input: n = 2, preferences = [[1], [0]], pairs = [[1, 0]]
 * Output: 0
 * Explanation: Both friends 0 and 1 are happy.
 * Example 3:
 * <p>
 * Input: n = 4, preferences = [[1, 3, 2], [2, 3, 0], [1, 3, 0], [0, 2, 1]], pairs = [[1, 3], [0, 2]]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= n <= 500
 * n is even.
 * preferences.length == n
 * preferences[i].length == n - 1
 * 0 <= preferences[i][j] <= n - 1
 * preferences[i] does not contain i.
 * All values in preferences[i] are unique.
 * pairs.length == n/2
 * pairs[i].length == 2
 * xi != yi
 * 0 <= xi, yi <= n - 1
 * Each person is contained in exactly one pair.
 *
 * @author chen
 * @date 2021/8/14
 **/
public class Solution {
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		Map<Integer, Integer>[] hash = new HashMap[n];
		for (int i = 0; i < n; i++) {
			hash[i] = new HashMap<>();
			for (int j = 0; j < preferences[i].length; j++) {
				hash[i].put(preferences[i][j], j);
			}
		}

		int ans = 0;
		final int n2 = pairs.length;
		for (int i = 0; i < n2; i++) {
			int x = pairs[i][0], y = pairs[i][1];
			boolean xh = false, yh = false;
			for (int j = 0; j < n2; j++) {
				if (i == j) continue;
				int u = pairs[j][0], v = pairs[j][1];
				if (!xh && check(x, y, u, v, hash)) xh = true;
				if (!yh && check(y, x, u, v, hash)) yh = true;
				if (xh && yh) break;
			}
			if (xh) ans++;
			if (yh) ans++;
		}
		return ans;
	}

	boolean check(int x, int y, int u, int v, Map<Integer, Integer>[] hash) {
		final int xy = hash[x].getOrDefault(y, Integer.MAX_VALUE),
				xu = hash[x].getOrDefault(u, Integer.MAX_VALUE),
				xv = hash[x].getOrDefault(v, Integer.MAX_VALUE),
				ux = hash[u].getOrDefault(x, Integer.MAX_VALUE),
				uv = hash[u].getOrDefault(v, Integer.MAX_VALUE),
				vx = hash[v].getOrDefault(x, Integer.MAX_VALUE),
				vu = hash[v].getOrDefault(u, Integer.MAX_VALUE);
		return (xy > xu && ux < uv) || (xy > xv && vx < vu);
	}
}