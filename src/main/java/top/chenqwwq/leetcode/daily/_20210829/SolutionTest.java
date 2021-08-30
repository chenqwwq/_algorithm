package top.chenqwwq.leetcode.daily._20210829;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/8/29
 **/
class SolutionTest {

	@Test
	void sumOddLengthSubarrays() {
		Solution solution = new Solution();
		Assertions.assertEquals(58, solution.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
	}
}
