package top.chenqwwq.leetcode.lcof._2021._42;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-02
 **/
class SolutionTest {

	@Test
	void maxSubArray() {
		Solution solution = new Solution();
		Assertions.assertEquals(1, solution.maxSubArray(new int[]{-2, 1}));
	}
}