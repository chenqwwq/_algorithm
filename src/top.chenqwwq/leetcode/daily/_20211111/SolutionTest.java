package top.chenqwwq.leetcode.daily._20211111;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-11-11
 **/
class SolutionTest {

	@Test
	void kInversePairs() {
		Solution solution = new Solution();
		Assertions.assertEquals(solution.kInversePairs(3, 1), 2);
		Assertions.assertEquals(solution.kInversePairs(3, 0), 1);
		Assertions.assertEquals(solution.kInversePairs(2, 2), 0);
	}
}