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
		Assertions.assertEquals(12, solution.largestRectangleArea(new int[]{5,5,1,7,1,1,5,2,7,6}));
		Assertions.assertEquals(6, solution.largestRectangleArea(new int[]{1, 4, 3, 2, 1, 3}));
		Assertions.assertEquals(8, solution.largestRectangleArea(new int[]{1, 4, 3, 2, 3}));
		Assertions.assertEquals(6, solution.largestRectangleArea(new int[]{1, 4, 2, 3}));
		Assertions.assertEquals(6, solution.largestRectangleArea(new int[]{1, 2, 3, 4}));
		Assertions.assertEquals(3, solution.largestRectangleArea(new int[]{2, 1, 2}));
		Assertions.assertEquals(16, solution.largestRectangleArea(new int[]{4, 4, 4, 4}));
		Assertions.assertEquals(6, solution.largestRectangleArea(new int[]{4, 3, 2, 1}));
		// [2,1,5,6,2,3]
		Assertions.assertEquals(10, solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
	}
}