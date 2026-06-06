package top.chenqwwq.leetcode.contest.weekly._250._2;

import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/18
 **/
class SolutionTest {

	@Test
	void addRungs() {
		Solution solution = new Solution();
		solution.addRungs(new int[]{4, 8, 12, 16}, 3);
		solution.addRungs(new int[]{1, 3, 5, 10}, 2);
	}
}