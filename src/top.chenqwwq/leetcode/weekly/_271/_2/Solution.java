package top.chenqwwq.leetcode.weekly._271._2;

import java.util.PriorityQueue;

/**
 * @author chenbingxin
 * @date 2021/12/12
 **/
public class Solution {

	public long subArrayRanges(int[] nums) {
		final int n = nums.length;
		long ans = 0;
		for (int i = 0; i < n; i++) {
			PriorityQueue<Integer> asc = new PriorityQueue<Integer>(), desc = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
			asc.add(nums[i]);
			desc.add(nums[i]);
			for (int j = i + 1; j < n; j++) {
				asc.add(nums[j]);
				desc.add(nums[j]);
				ans += desc.peek() - asc.peek();
			}
		}
		return ans;
	}

}