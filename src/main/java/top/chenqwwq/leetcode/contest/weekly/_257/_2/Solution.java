package top.chenqwwq.leetcode.contest.weekly._257._2;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/9/5
 **/
public class Solution {

	public int numberOfWeakCharacters(int[][] properties) {
		final int n = properties.length;
		Arrays.sort(properties, (o, p) -> o[0] == p[0] ? o[1] - p[1] : p[0] - o[0]);
		return 0;
	}
}