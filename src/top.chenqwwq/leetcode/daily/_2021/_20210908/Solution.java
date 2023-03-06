package top.chenqwwq.leetcode.daily._2021._20210908;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/9/8
 **/
public class Solution {

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		final int n = profits.length;
		int[][] invests = new int[n][2];
		for (int i = 0; i < n; i++) {
			invests[i][0] = capital[i];
			invests[i][1] = profits[i];
		}

		Arrays.sort(invests, Comparator.comparingInt(o -> o[0]));

		int ans = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		for (int i = 0, j = 0; j < k; j++) {
			while (i < n && invests[i][0] <= w) {
				queue.add(invests[i][1]);
				i++;
			}
			if (queue.isEmpty()) {
				return w;
			}
			w += queue.poll();
		}
		return w;
	}
}