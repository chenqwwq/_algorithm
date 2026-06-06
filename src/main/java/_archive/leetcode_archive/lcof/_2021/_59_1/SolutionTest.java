package top.chenqwwq.leetcode.archive.lcof._2021._59_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-27
 **/
class SolutionTest {

	@Test
	void maxSlidingWindow() {
		Solution solution = new Solution();
		Assertions.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
	}
}