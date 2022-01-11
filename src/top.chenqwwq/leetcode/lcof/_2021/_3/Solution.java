package top.chenqwwq.leetcode.lcof._2021._3;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 *
 * @author chen
 * @date 2021-05-26
 **/
public class Solution {
	public int findRepeatNumber(int[] nums) {
		Set<Integer> hash = new HashSet<>();
		for (int i : nums) {
			final boolean add = hash.add(i);
			if (!add) {
				return i;
			}
		}
		return -1;
	}
}