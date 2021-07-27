package top.chenqwwq.leetcode.daily._20210726;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-26
 **/
class SolutionTest {

	@Test
	void minOperations() {
		//  * Input: target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
		Solution solution = new Solution();
		Assertions.assertEquals(3, solution.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1}));
	}
}