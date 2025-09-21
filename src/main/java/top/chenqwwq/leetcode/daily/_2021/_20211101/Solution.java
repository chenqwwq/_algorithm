package top.chenqwwq.leetcode.daily._2021._20211101;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @date 2021-11-01
 **/
public class Solution {
	public int distributeCandies(int[] candyType) {
		final int n = candyType.length;
		final Set<Integer> set = new HashSet<>();
		for (int i : candyType) {
			set.add(i);
		}

		final int target = n >> 1, types = set.size();
		return Math.min(target,types);
	}
}