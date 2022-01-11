package top.chenqwwq.leetcode.daily._20210524;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-24
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void strangePrinter() {
		Assertions.assertEquals(19, solution.strangePrinter("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa"));
		Assertions.assertEquals(2, solution.strangePrinter("aaabbb"));
		Assertions.assertEquals(2, solution.strangePrinter("aba"));
		Assertions.assertEquals(6, solution.strangePrinter("bcbacbbda"));
		Assertions.assertEquals(4, solution.strangePrinter("cbacbb"));
	}
}