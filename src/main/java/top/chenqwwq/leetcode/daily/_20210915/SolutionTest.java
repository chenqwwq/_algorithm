package top.chenqwwq.leetcode.daily._20210915;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-09-15
 **/
class SolutionTest {

	@Test
	void findPeakElement() {
		Solution solution = new Solution();
		Assertions.assertEquals(1, solution.findPeakElement(new int[]{-2147483648, -2147483647}));
		Assertions.assertEquals(0, solution.findPeakElement(new int[]{2, 1, 2}));
		Assertions.assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3}));
		Assertions.assertEquals(2, solution.findPeakElement(new int[]{1, 2, 3, 1}));
		Assertions.assertEquals(5, solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));

	}
}