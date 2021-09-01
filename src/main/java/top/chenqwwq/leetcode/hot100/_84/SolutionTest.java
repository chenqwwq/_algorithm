package top.chenqwwq.leetcode.hot100._84;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-09-01
 **/
class SolutionTest {

	@Test
	void largestRectangleArea() {
		Solution solution = new Solution();
		// [2,1,5,6,2,3]
		Assertions.assertEquals(10, solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
	}
}