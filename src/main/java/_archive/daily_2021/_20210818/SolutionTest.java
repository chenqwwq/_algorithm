package top.chenqwwq.leetcode.daily._2021._20210818;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-18
 **/
class SolutionTest {

	@Test
	void checkRecord() {
		Solution solution = new Solution();
		Assertions.assertEquals(19, solution.checkRecord(3));
		Assertions.assertEquals(3, solution.checkRecord(1));
		Assertions.assertEquals(8, solution.checkRecord(2));
	}
}