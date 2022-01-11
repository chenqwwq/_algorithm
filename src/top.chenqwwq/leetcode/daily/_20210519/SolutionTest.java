package top.chenqwwq.leetcode.daily._20210519;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-19
 **/
class SolutionTest {


	Solution solution = new Solution();

	@Test
	void kthLargestValue() {
		Assertions.assertEquals(7, solution.kthLargestValue(new int[][]{
				{5, 2},
				{1, 6}
		}, 1));
		Assertions.assertEquals(5, solution.kthLargestValue(new int[][]{
				{5, 2},
				{1, 6}
		}, 2));
		Assertions.assertEquals(0, solution.kthLargestValue(new int[][]{
				{5, 2},
				{1, 6}
		}, 4));
		Assertions.assertEquals(4, solution.kthLargestValue(new int[][]{
				{5, 2},
				{1, 6}
		}, 3));
		Assertions.assertEquals(14, solution.kthLargestValue(new int[][]{
				{8, 10, 5, 8, 5, 7, 6, 0, 1, 4, 10, 6, 4, 3, 6, 8, 7, 9, 4, 2},
		}, 2));
	}
}