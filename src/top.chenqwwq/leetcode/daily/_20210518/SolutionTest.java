package top.chenqwwq.leetcode.daily._20210518;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-18
 **/
class SolutionTest {


	Solution solution = new Solution();

	@Test
	void countTriplets() {
		Assertions.assertEquals(4, solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
		Assertions.assertEquals(10, solution.countTriplets(new int[]{1, 1, 1, 1, 1}));
		Assertions.assertEquals(0, solution.countTriplets(new int[]{2, 3}));
		Assertions.assertEquals(3, solution.countTriplets(new int[]{1, 3, 5, 7, 9}));
		Assertions.assertEquals(8, solution.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
	}
}