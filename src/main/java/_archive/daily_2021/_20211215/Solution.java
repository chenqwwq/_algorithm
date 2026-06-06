package top.chenqwwq.leetcode.daily._2021._20211215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author chenbingxin
 * @date 2021/12/15
 **/
public class Solution {
	public int[] loudAndRich(int[][] richer, int[] quiet) {
		// n 个人
		final int n = quiet.length;

		final int[] ans = new int[n];
		Arrays.fill(ans, Integer.MAX_VALUE);

		final List<Integer>[] map = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<>();
		}

		for (int[] rich : richer) {
			map[rich[1]].add(rich[0]);
		}

		final Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			stack.add(i);
			int t = i, q = quiet[i];
			while (!stack.isEmpty()) {
				final Integer pop = stack.pop();
				if (q > quiet[pop]) {
					q = quiet[pop];
					t = pop;
				}
				for (int p : map[pop]) {
					if (ans[p] != Integer.MAX_VALUE) {
						if (q > quiet[ans[p]]) {
							q = quiet[ans[p]];
							t = ans[p];
						}
						continue;
					}
					stack.add(p);
				}
			}
			ans[i] = t;
		}
		return ans;
	}
}
