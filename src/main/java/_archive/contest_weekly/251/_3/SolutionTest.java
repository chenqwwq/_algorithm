package top.chenqwwq.leetcode.contest.weekly._251._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/25
 **/
class SolutionTest {

	@Test
	void maxCompatibilitySum() {
		Solution solution = new Solution();
		final int i = solution.maxCompatibilitySum(new int[][]{
				{0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 1, 0, 0}
		}, new int[][]{
				{1, 0, 0, 0, 0, 1}, {0, 1, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 1}
		});
		Assertions.assertEquals(10, i);
		final int i1 = solution.maxCompatibilitySum(new int[][]{
				{1, 1, 0}, {1, 0, 1}, {0, 0, 1}
		}, new int[][]{
				{1, 0, 0}, {0, 0, 1}, {1, 1, 0}
		});
		Assertions.assertEquals(8, i1);
	}
}