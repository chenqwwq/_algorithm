package top.chenqwwq.leetcode.archive.lcof._2021._33;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/17
 **/
class SolutionTest {

	@Test
	void verifyPostorder() {
		Solution solution = new Solution();
		Assertions.assertFalse(solution.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
	}
}