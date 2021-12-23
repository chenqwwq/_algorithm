package top.chenqwwq.leetcode.weekly._253._2;

import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/8/8
 **/
public class Solution {
	public int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		int total = 0;
		for (int pile : piles) {
			queue.offer(pile);
			total += pile;
		}

		while (k-- > 0) {
			Integer poll = queue.poll();
			int ch = poll / 2;
			total -= ch;
			queue.offer(poll - ch);

		}
		return total;
	}
}