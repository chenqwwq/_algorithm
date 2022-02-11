package top.chenqwwq.leetcode.hot100._621;

/**
 * @author chen
 * @date 2021-08-31
 **/
public class Solution {
	public int leastInterval(char[] tasks, int n) {
		// 没有cd
		if (n == 0) {
			return tasks.length;
		}

		// 以为cd是一样的,所以可以认为就是把其他任务塞到任务数最大的cd里面
		int[] hash = new int[26];
		int max = 0;
		for (char c : tasks) {
			max = Math.max(max, ++hash[c - 'A']);
		}

		int maxCnt = 0;
		for (int cnt : hash) {
			if (cnt == max) {
				maxCnt++;
			}
		}

		return Math.max((max - 1) * (n + 1) + maxCnt, tasks.length);
	}
}