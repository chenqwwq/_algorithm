package top.chenqwwq.leetcode.daily._2021._20211202;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/2
 **/
public class Solution {

	public static final Map<Integer, String> MEDALS = new HashMap<>();

	static {
		MEDALS.put(1, "Gold Medal");
		MEDALS.put(2, "Silver Medal");
		MEDALS.put(3, "Bronze Medal");
	}

	public String[] findRelativeRanks(int[] score) {
		final int n = score.length;
		final int[] hash = new int[n];
		System.arraycopy(score, 0, hash, 0, n);
		Arrays.sort(hash);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(hash[i], i);
		}

		String[] ans = new String[n];
		for (int i = 0; i < n; i++) {
			final Integer rang = n - map.get(score[i]);
			ans[i] = MEDALS.getOrDefault(rang, String.valueOf(rang));
		}
		return ans;
	}
}