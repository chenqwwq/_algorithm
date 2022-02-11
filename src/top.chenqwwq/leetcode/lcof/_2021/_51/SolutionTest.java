package top.chenqwwq.leetcode.lcof._2021._51;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-12
 **/
class SolutionTest {

	@Test
	void reversePairs() {
		Solution solution = new Solution();
		Assertions.assertEquals(33,solution.reversePairs(new int[]{7,5,6,4,4,6,7,8,234,2,6,7,4}));
		Assertions.assertEquals(5, solution.reversePairs(new int[]{7, 5, 6, 4}));
	}
}