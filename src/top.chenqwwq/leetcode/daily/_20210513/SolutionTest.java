package top.chenqwwq.leetcode.daily._20210513;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-13
 **/
class SolutionTest {

	/**
	 * * 示例 1：
	 * * <p>
	 * * 输入：steps = 3, arrLen = 2
	 * * 输出：4
	 * * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
	 * * 向右，向左，不动
	 * * 不动，向右，向左
	 * * 向右，不动，向左
	 * * 不动，不动，不动
	 * * 示例  2：
	 * * <p>
	 * * 输入：steps = 2, arrLen = 4
	 * * 输出：2
	 * * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
	 * * 向右，向左
	 * * 不动，不动
	 * * 示例 3：
	 * * <p>
	 * * 输入：steps = 4, arrLen = 2
	 * * 输出：8
	 * * <p>
	 * * <p>
	 */

	Solution solution = new Solution();

	@Test
	void numWays() {
		Assertions.assertEquals(318671228, solution.numWays(47, 38));
		Assertions.assertEquals(9, solution.numWays(4, 3));
		Assertions.assertEquals(4, solution.numWays(3, 3));
		Assertions.assertEquals(4, solution.numWays(3, 2));
		Assertions.assertEquals(2, solution.numWays(2, 4));
		Assertions.assertEquals(8, solution.numWays(4, 2));
	}
}