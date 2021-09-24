package top.chenqwwq.leetcode.lccup._2021._2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/9/11
 **/
public class Solution {
	public int maxmiumScore(int[] cards, int cnt) {
		Arrays.sort(cards);
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
		int ans = 0;
		final int n = cards.length;
		int w1 = 0, w2 = 0;
		for (int i = n - 1; i >= 0; i--) {
			if ((cards[i] & 1) == 0) {
				if ((cnt & 1) == 1) {
					ans += cards[i];
					cnt--;
				} else if (w2 == 0) {
					w2 = cards[i];
				} else {
					queue.add(cards[i] + w2);
					w2 = 0;
				}
			} else if (w1 == 0) {
				w1 = cards[i];
			} else {
				queue.add(w1 + cards[i]);
				w1 = 0;
			}
		}

		while (cnt > 0 && !queue.isEmpty()) {
			ans += queue.poll();
			cnt-=2;
		}
		return cnt == 0 ? ans : 0;
	}
}