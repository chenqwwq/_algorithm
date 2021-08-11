package top.chenqwwq.leetcode.daily._20210810;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-10
 **/
class SolutionTest {

	@Test
	void numberOfArithmeticSlices() {
		Solution solution = new Solution();
		Assertions.assertEquals(1, solution.numberOfArithmeticSlices(new int[]{1, 2, 3}));
		Assertions.assertEquals(3, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
		Assertions.assertEquals(0, solution.numberOfArithmeticSlices(new int[]{1}));
		Assertions.assertEquals(6, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
		Assertions.assertEquals(10, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6}));
		Assertions.assertEquals(15, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6, 7}));
		Assertions.assertEquals(21, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
	}
}