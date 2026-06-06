package top.chenqwwq.leetcode.contest.weekly._251._3;

/**
 * @author chen
 * @date 2021/7/25
 **/
public class Solution {
	int k;

	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		final int m = students.length;
		k = students[0].length;
		int[] newStudents = new int[m];
		for (int i = 0; i < m; i++) {
			newStudents[i] = getNum(students[i]);
		}
		int[] newMentors = new int[m];
		for (int i = 0; i < m; i++) {
			newMentors[i] = getNum(mentors[i]);
		}

		return dfs(newStudents, newMentors);
	}

	public int dfs(int[] students, int[] mentors) {
		return dfs(students, mentors, 0, new boolean[students.length]);
	}

	public int dfs(int[] students, int[] mentors, int curr, boolean[] exist) {
		final int n = students.length;
		if (curr == n) {
			return 0;
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (exist[i]) {
				continue;
			}
			exist[i] = true;
			ans = Math.max(ans, getCnt(students[curr] ^ mentors[i] ^ (Integer.MAX_VALUE >> (32 - k - 1))) + dfs(students, mentors, curr + 1, exist));
			exist[i] = false;
		}
		return ans;
	}

	private int getNum(int[] arr) {
		final int n = arr.length;
		int ans = 0, level = 1;
		for (int i = n - 1; i >= 0; i--) {
			ans += (arr[i] * level);
			level *= 2;
		}
		return ans;
	}

	public int getCnt(int num) {
		num <<= (32 - k);
		int ans = 0;
		while (num != 0) {
			num &= (num - 1);
			ans++;
		}
		return ans;
	}
}