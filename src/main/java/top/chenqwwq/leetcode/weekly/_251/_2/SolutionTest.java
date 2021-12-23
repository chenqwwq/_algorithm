package top.chenqwwq.leetcode.weekly._251._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author chen
 * @date 2021/7/25
 **/
class SolutionTest {

	@Test
	void maximumNumber() {
		Solution solution = new Solution();
		Assertions.assertEquals("334999",solution.maximumNumber("334111",new int[]{0,9,2,3,3,2,5,5,5,5}));
	}
}