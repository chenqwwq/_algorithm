package top.chenqwwq.leetcode.daily._2021._20211109;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/11/9
 **/
class SolutionTest {

	@Test
	void findMinStep() {
		Assertions.assertEquals(2, new Solution().findMinStep("RRWWRRBBRR", "WB"));
		Assertions.assertEquals(3, new Solution().findMinStep("RBYYBBRRB", "YRBGB"));
		Assertions.assertEquals(2, new Solution().findMinStep("WWRRBBWW", "WRBRW"));
	}
}