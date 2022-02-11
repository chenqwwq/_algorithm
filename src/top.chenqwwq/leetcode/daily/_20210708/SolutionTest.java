package top.chenqwwq.leetcode.daily._20210708;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-08
 **/
class SolutionTest {

	@Test
	void numSubarraysWithSum() {
		Solution solution = new Solution();
		Assertions.assertEquals(15, solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
		Assertions.assertEquals(4, solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
	}
}