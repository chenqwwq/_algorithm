package top.chenqwwq.leetcode.topic.union_find._128;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-08
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void longestConsecutive() {
		Assertions.assertEquals(4, solution.longestConsecutive(new int[]{100, 4, 200, 1, 2, 3}));
		Assertions.assertEquals(9, solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
	}
}