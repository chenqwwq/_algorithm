package top.chenqwwq.leetcode.topic.dp.pack._01._474;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/9/11
 **/
class SolutionTest {

	@Test
	void findMaxForm() {
		Solution solution = new Solution();
		Assertions.assertEquals(2, solution.findMaxForm(new String[]{"01", "0", "1"}, 1, 1));
	}
}