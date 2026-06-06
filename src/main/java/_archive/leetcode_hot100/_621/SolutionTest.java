package top.chenqwwq.leetcode.hot100._621;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021-08-31
 **/
class SolutionTest {

	@Test
	void leastInterval() {
		Solution solution = new Solution();
		Assertions.assertEquals(16,solution.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
		Assertions.assertEquals(8,solution.leastInterval(new char[]{'A','A','A','B','B','B'},2));
	}
}