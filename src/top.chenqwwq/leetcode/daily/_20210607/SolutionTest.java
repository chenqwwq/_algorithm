package top.chenqwwq.leetcode.daily._20210607;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-07
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void findTargetSumWays() {
		Assertions.assertEquals(2, solution.findTargetSumWays(new int[]{1, 0}, 1));
		Assertions.assertEquals(5, solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
	}
}