package top.chenqwwq.leetcode.daily._20210619;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/6/19
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void maxLength() {
		Assertions.assertEquals(4, solution.maxLength(Arrays.asList("zog","nvwsuikgndmfexxgjtkb","nxko")));
		Assertions.assertEquals(0, solution.maxLength(Arrays.asList("yy", "bkhwmpbiisbldzknpm")));
	}
}