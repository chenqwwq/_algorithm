package top.chenqwwq.leetcode.daily._20210801;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/8/1
 **/
public class Solution {
	public int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(((Comparator<int[]>) (o1, o2) -> Integer.compare(o1[0], o2[0])).thenComparing((o1, o2) -> Integer.compare(o1[1], o2[1])));
		for (int i = 0; i < mat.length; i++) {
			queue.add(new int[]{getNum(mat[i]), i});
		}

		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = queue.poll()[1];
		}
		return ans;
	}

	public int getNum(int[] m) {
		int ans = 0;
		for (int num : m) {
			if (num == 1) {
				ans++;
			}
		}
		return ans;
	}
}