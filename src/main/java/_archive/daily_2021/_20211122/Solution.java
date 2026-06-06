package top.chenqwwq.leetcode.daily._2021._20211122;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chen
 * @date 2021-11-22
 **/
public class Solution {

	private final int[] raw;
	private final List<Integer> shuffle;

	public Solution(int[] nums) {
		raw = nums;
		shuffle = Arrays.stream(raw).boxed().collect(Collectors.toList());
	}

	public int[] reset() {
		return raw;
	}

	public int[] shuffle() {
		Collections.shuffle(shuffle);
		final int n = raw.length;
		int[] ans = new int[n];
		for (int i = 0;i < n;i++){
			ans[i] = shuffle.get(i);
		}
		return ans;
	}
}