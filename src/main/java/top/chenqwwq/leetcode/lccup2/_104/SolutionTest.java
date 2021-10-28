package top.chenqwwq.leetcode.lccup2._104;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/10/27
 **/
class SolutionTest {

	@Test
	void combinationSum4() {
		Solution solution = new Solution();
		Assertions.assertEquals(solution.combinationSum4(new int[]{1, 2, 3}, 4), 7);
	}
}