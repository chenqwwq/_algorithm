package top.chenqwwq.leetcode.contest.weekly._256._2;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chen
 * @date 2021/8/29
 **/
public class Solution {
	public String kthLargestNumber(String[] nums, int k) {
		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return new BigDecimal(o2).compareTo(new BigDecimal(o1));
			}
		});

		return nums[k - 1];

	}
}