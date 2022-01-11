package top.chenqwwq.leetcode.lcof._2021._38;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-14
 **/
class SolutionTest {

	@Test
	void permutation() {
		Solution solution = new Solution();
		Assertions.assertArrayEquals(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}, solution.permutation("abc"));
	}
}