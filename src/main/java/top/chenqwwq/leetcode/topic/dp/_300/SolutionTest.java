package top.chenqwwq.leetcode.topic.dp._300;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-24
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void lengthOfLIS() {
		Assertions.assertEquals(4, solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
		Assertions.assertEquals(4, solution.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
		Assertions.assertEquals(1, solution.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
		Assertions.assertEquals(6, solution.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));

	}
}