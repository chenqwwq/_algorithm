package top.chenqwwq.leetcode.weekly._255._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/8/22
 **/
class SolutionTest {

	@Test
	void minimizeTheDifference() {
		Solution solution = new Solution();
		Assertions.assertEquals(94, solution.minimizeTheDifference(new int[][]{{1}, {2}, {3}}, 100));
		Assertions.assertEquals(0, solution.minimizeTheDifference(new int[][]{
				{1, 2, 3}, {4, 5, 6}, {7, 8, 9}
		}, 13));
	}
}