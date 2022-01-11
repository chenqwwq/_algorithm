package top.chenqwwq.leetcode.daily._20210507;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-07
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void xorOperation() {
		Assertions.assertEquals(8, solution.xorOperation(5, 0));
		Assertions.assertEquals(8, solution.xorOperation(4, 3));
		Assertions.assertEquals(7, solution.xorOperation(1, 7));
		Assertions.assertEquals(2, solution.xorOperation(10, 5));
	}
}