package top.chenqwwq.leetcode.weekly._250._1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/18
 **/
class SolutionTest {

	@Test
	void maxPoints() {
		Solution solution = new Solution();
		Assertions.assertEquals(11, solution.maxPoints(new int[][]{
				{1, 5}, {3, 2}, {4, 2}
		}));
		Assertions.assertEquals(9, solution.maxPoints(new int[][]{
				{1, 2, 3}, {1, 5, 1}, {3, 1, 1}
		}));
	}
}