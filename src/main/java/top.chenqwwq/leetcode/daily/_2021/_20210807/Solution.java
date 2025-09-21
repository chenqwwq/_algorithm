package top.chenqwwq.leetcode.daily._2021._20210807;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 457. Circular Array Loop
 * You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:
 * <p>
 * If nums[i] is positive, move nums[i] steps forward, and
 * If nums[i] is negative, move nums[i] steps backward.
 * Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.
 * <p>
 * A cycle in the array consists of a sequence of indices seq of length k where:
 * <p>
 * Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * Every nums[seq[j]] is either all positive or all negative.
 * k > 1
 * Return true if there is a cycle in nums, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,-1,1,2,2]
 * Output: true
 * Explanation:
 * There is a cycle from index 0 -> 2 -> 3 -> 0 -> ...
 * The cycle's length is 3.
 * Example 2:
 * <p>
 * Input: nums = [-1,2]
 * Output: false
 * Explanation:
 * The sequence from index 1 -> 1 -> 1 -> ... is not a cycle because the sequence's length is 1.
 * By definition the sequence's length must be strictly greater than 1 to be a cycle.
 * Example 3:
 * <p>
 * Input: nums = [-2,1,-1,-2,-2]
 * Output: false
 * Explanation:
 * The sequence from index 1 -> 2 -> 1 -> ... is not a cycle because nums[1] is positive, but nums[2] is negative.
 * Every nums[seq[j]] must be either all positive or all negative.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 * <p>
 * <p>
 * Follow up: Could you solve it in O(n) time complexity and O(1) extra space complexity?
 *
 * @author chen
 * @date 2021/8/7
 **/
public class Solution {
	public boolean circularArrayLoop(int[] nums) {
		return false;
	}

	public boolean topu(int[] nums) {
		final int n = nums.length;
		// 拓扑排序
		final int[] degree = new int[n];
		final int[] fin = new int[n];

		for (int i = 0; i < n; i++) {
			degree[(fin[i] = getTarget(i, n, nums[i]))]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		// 将所有入度为0的节点入队列
		for (int i = 0; i < n; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			final Integer poll = queue.poll();
			if (--degree[fin[poll]] == 0) {
				queue.offer(fin[poll]);
			}
		}
		return false;
	}

	public int getTarget(int target, int len, int move) {
		target += move;
		if (target < 0) {
			return len + target;
		} else if (target >= len) {
			return target - len;
		} else {
			return target;
		}
	}
}