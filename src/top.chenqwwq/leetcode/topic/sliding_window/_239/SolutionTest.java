package top.chenqwwq.leetcode.topic.slidingwindow._239;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-11
 **/
class SolutionTest {

	/**
	 * Example 1:
	 * * <p>
	 * * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
	 * * Output: [3,3,5,5,6,7]
	 * * Explanation:
	 * * Window position                Max
	 * * ---------------               -----
	 * * [1  3  -1] -3  5  3  6  7       3
	 * * 1 [3  -1  -3] 5  3  6  7       3
	 * * 1  3 [-1  -3  5] 3  6  7       5
	 * * 1  3  -1 [-3  5  3] 6  7       5
	 * * 1  3  -1  -3 [5  3  6] 7       6
	 * * 1  3  -1  -3  5 [3  6  7]      7
	 * * Example 2:
	 * * <p>
	 * * Input: nums = [1], k = 1
	 * * Output: [1]
	 * * Example 3:
	 * * <p>
	 * * Input: nums = [1,-1], k = 1
	 * * Output: [1,-1]
	 * * Example 4:
	 * * <p>
	 * * Input: nums = [9,11], k = 2
	 * * Output: [11]
	 * * Example 5:
	 * * <p>
	 * * Input: nums = [4,-2], k = 2
	 * * Output: [4]
	 */

	Solution solution = new Solution();

	@Test
	void maxSlidingWindow() {
		Assertions.assertArrayEquals(new int[]{3, 3, 2, 5}, solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3));
		Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
		Assertions.assertArrayEquals(new int[]{1}, solution.maxSlidingWindow(new int[]{1}, 1));
		Assertions.assertArrayEquals(new int[]{1, -1}, solution.maxSlidingWindow(new int[]{1, -1}, 1));
		Assertions.assertArrayEquals(new int[]{11}, solution.maxSlidingWindow(new int[]{9, 11}, 2));
		Assertions.assertArrayEquals(new int[]{4}, solution.maxSlidingWindow(new int[]{4, -2}, 2));
	}
}