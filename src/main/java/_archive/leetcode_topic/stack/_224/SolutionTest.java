package top.chenqwwq.leetcode.topic.stack._224;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/25
 **/
class SolutionTest {
	Solution solution = new Solution();

	@Test
	void calculate() {
		Assertions.assertEquals(2,solution.calculate("1 + 1"));
		Assertions.assertEquals(3,solution.calculate(" 2-1 + 2 "));
		Assertions.assertEquals(23,solution.calculate("(1+(4+5+2)-3)+(6+8)"));
		Assertions.assertEquals(-12,solution.calculate("- (3 + (4 + 5))"));
	}
}