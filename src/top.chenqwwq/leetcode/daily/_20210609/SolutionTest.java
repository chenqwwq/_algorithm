package top.chenqwwq.leetcode.daily._20210609;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-09
 **/
class SolutionTest {

	/**
	 * 示例 1：
	 * <p>
	 * 输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
	 * 输出：2
	 * 解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
	 * 总的来说，有两种计划。
	 * 示例 2：
	 * <p>
	 * 输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
	 * 输出：7
	 * 解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
	 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
	 * <p>
	 */
	Solution solution = new Solution();

	@Test
	void profitableSchemes() {
		Assertions.assertEquals(2, solution.profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
		Assertions.assertEquals(7, solution.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
	}
}