package top.chenqwwq.leetcode.daily._20210714;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-14
 **/
class SolutionTest {

	@Test
	void bsLess() {
		Solution solution = new Solution();

		Assertions.assertEquals(4, solution.bsLess(new int[]{1, 2, 4, 4, 7, 10}, 9));

		final int[] nums = {1, 2, 3, 5, 5, 6, 7};
		Assertions.assertEquals(2, solution.bsLess(nums, 4));
		Assertions.assertEquals(nums.length - 1, solution.bsLess(nums, 7));
		Assertions.assertEquals(nums.length - 1, solution.bsLess(nums, 8));
		Assertions.assertEquals(3, solution.bsLess(nums, 5));
		Assertions.assertEquals(2, solution.bsLess(nums, 3));
	}

	@Test
	void minAbsoluteSumDiff() {
		Solution solution = new Solution();
		Assertions.assertEquals(20, solution.minAbsoluteSumDiff(new int[]{1, 10, 4, 4, 2, 7}, new int[]{9, 3, 5, 1, 7, 4}));
	}
}