package top.chenqwwq.leetcode.daily._20210715;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-15
 **/
class SolutionTest {

	@Test
	void maximumElementAfterDecrementingAndRearranging() {
		Solution solution = new Solution();
		Assertions.assertEquals(2, solution.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}));
		Assertions.assertEquals(3, solution.maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
		Assertions.assertEquals(5, solution.maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}));
	}
}