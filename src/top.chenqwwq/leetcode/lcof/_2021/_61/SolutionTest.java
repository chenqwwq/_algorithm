package top.chenqwwq.leetcode.lcof._2021._61;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-09
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void isStraight() {
		Assertions.assertFalse(solution.isStraight(new int[]{3, 5, 1, 2, 7}));
		Assertions.assertTrue(solution.isStraight(new int[]{0, 0, 0, 0, 0}));
		Assertions.assertTrue(solution.isStraight(new int[]{0, 0, 1, 2, 3}));
		Assertions.assertTrue(solution.isStraight(new int[]{0, 0, 1, 2, 4}));
		Assertions.assertFalse(solution.isStraight(new int[]{0, 0, 1, 2, 7}));
	}
}