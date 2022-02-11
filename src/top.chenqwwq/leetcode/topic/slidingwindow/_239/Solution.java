package top.chenqwwq.leetcode.topic.slidingwindow._239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 239. Sliding Window Maximum
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 * <p>
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 * <p>
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 * <p>
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * @author chen
 * @date 2021-05-11
 **/
public class Solution {

	public int[] maxSlidingWindow(int[] nums, int k) {
		// 单调队列 递减
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
		}

		final int[] ans = new int[nums.length - k + 1];
		ans[0] = nums[deque.peek()];
		for (int i = k; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
			while (deque.peek() <= i - k) {
				deque.pop();
			}
			ans[i - k + 1] = nums[deque.peek()];
		}
		return ans;
	}

//	public int[] maxSlidingWindow(int[] nums, int k) {
//		final int n = nums.length;
//		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((Comparator<int[]>) (o1, o2) -> Integer.compare(o2[0], o1[0])).thenComparing((o1, o2) -> Integer.compare(o2[1], o1[1])));
//		final int len = n - k + 1;
//		final int[] ans = new int[len];
//
//		// 初始数据
//		int i = 0;
//		for (; i < k; i++) {
//			priorityQueue.offer(new int[]{nums[i], i});
//		}
//		ans[i - k] = priorityQueue.peek()[0];
//		for (; i < n; i++) {
//			priorityQueue.add(new int[]{nums[i], i});
//			while (priorityQueue.peek()[1] <= i - k) {
//				priorityQueue.poll();
//			}
//			ans[i - k + 1] = priorityQueue.peek()[0];
//		}
//		ans[len - 1] = priorityQueue.peek()[0];
//
//		return ans;
//	}
}

















