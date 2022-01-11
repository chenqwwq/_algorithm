package top.chenqwwq.leetcode.daily._20211211;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2021/12/11
 **/
public class TopVotedCandidate {

	int[] times, top;

	public TopVotedCandidate(int[] persons, int[] times) {
		this.times = times;
		final int n = persons.length;
		this.top = new int[n];
		int mv = 0, mp = 0;
		Map<Integer, Integer> voteFor = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int now = voteFor.getOrDefault(persons[i], 0) + 1;
			if (now >= mv) {
				mv = now;
				mp = persons[i];
			}
			top[i] = mp;
			voteFor.put(persons[i],now);
		}
	}

	public int q(int t) {
		int left = 0, right = times.length - 1;
		while (left < right) {
			final int mid = (left + right + 1) >> 1;
			if (times[mid] > t) {
				right = mid-1;
			}else{
				left = mid;
			}
		}
		return top[left];
	}
}