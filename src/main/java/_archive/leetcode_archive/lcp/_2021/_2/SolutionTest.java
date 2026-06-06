package top.chenqwwq.leetcode.archive.lcp._2021._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/9/11
 **/
class SolutionTest {

	@Test
	void maxmiumScore() {
		Solution solution = new Solution();
		Assertions.assertEquals(18, solution.maxmiumScore(new int[]{1, 3, 8, 9, 5}, 4));
		Assertions.assertEquals(18, solution.maxmiumScore(new int[]{1, 2, 8, 9}, 3));
	}
}