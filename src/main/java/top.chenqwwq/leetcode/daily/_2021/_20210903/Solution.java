package top.chenqwwq.leetcode.daily._2021._20210903;

import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021-09-03
 **/
public class Solution {
	public int[] smallestK(int[] arr, int k) {
		if (k == 0) {
			return new int[]{};
		}
		if (k >= arr.length) {
			return arr;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1, (o1, o2) -> Integer.compare(o2, o1));
		for (int num : arr) {
			queue.offer(num);
			while (queue.size() > k) {
				queue.poll();
			}
		}
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = queue.poll();
		}
		return ans;
	}
}