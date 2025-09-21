package top.chenqwwq.leetcode.daily._2021._20210927;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-09-27
 **/
class SolutionTest {

	@Test
	void numDecodings() {
		Solution solution = new Solution();
		Assertions.assertEquals(0, solution.numDecodings("1003"));
		Assertions.assertEquals(999, solution.numDecodings("***"));
	}
}