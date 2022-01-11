package top.chenqwwq.leetcode.daily._20210629;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-29
 **/
class SolutionTest {

	@Test
	void convertToTitle() {
		Solution solution = new Solution();
		Assertions.assertEquals("AA", solution.convertToTitle(27));
		Assertions.assertEquals("ZY", solution.convertToTitle(701));
	}
}