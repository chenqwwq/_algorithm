package top.chenqwwq.leetcode.unkown._363;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/5/29
 **/
class Solution_1Test {

	Solution_1 solution = new Solution_1();

	@Test
	void maxSumSubmatrix() {
		Assertions.assertEquals(8, solution.maxSumSubmatrix(new int[][]{
				{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}
		}, 8));
		Assertions.assertEquals(2, solution.maxSumSubmatrix(new int[][]{
				{1, 0, 1}, {0, -2, 3}
		}, 2));
		Assertions.assertEquals(3, solution.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 3));
		Assertions.assertEquals(-1, solution.maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0));
	}
}