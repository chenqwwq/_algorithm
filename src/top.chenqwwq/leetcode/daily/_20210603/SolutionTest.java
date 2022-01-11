package top.chenqwwq.leetcode.daily._20210603;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-03
 **/
class SolutionTest {
	Solution solution = new Solution();

	@Test
	void findMaxLength() {
		Assertions.assertEquals(2, solution.findMaxLength(new int[]{0, 1}));
		Assertions.assertEquals(2, solution.findMaxLength(new int[]{0, 1, 0}));
		Assertions.assertEquals(6, solution.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
	}
}