package top.chenqwwq.leetcode.biweek._57._2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/7/24
 **/
public class Solution {

	class Friend {
		int num;
		int arrival;
		int leaving;

		public Friend(int num, int arrival, int leaving) {
			this.num = num;
			this.arrival = arrival;
			this.leaving = leaving;
		}
	}

	public int smallestChair(int[][] times, int targetFriend) {
		final int n = times.length;
		Friend[] friends = new Friend[n];
		for (int i = 0; i < n; i++) {
			friends[i] = new Friend(i, times[i][0], times[i][1]);
		}
		Arrays.sort(friends, Comparator.comparingInt(o -> o.arrival));
		int max = 0;
		PriorityQueue<Integer> freeSite = new PriorityQueue<>();
		PriorityQueue<int[]> leavingAndSite = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

		for (Friend friend : friends) {
			while (!leavingAndSite.isEmpty() && leavingAndSite.peek()[0] <= friend.arrival) {
				freeSite.add(leavingAndSite.poll()[1]);
			}
			int site;
			if (freeSite.isEmpty()) {
				site = max++;
			} else {
				site = freeSite.poll();
			}
			if (friend.num == targetFriend) {
				return site;
			}
			leavingAndSite.offer(new int[]{friend.leaving, site});
		}
		return -1;
	}
}