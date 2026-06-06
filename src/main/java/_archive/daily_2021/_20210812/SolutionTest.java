package top.chenqwwq.leetcode.daily._2021._20210812;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-08-12
 **/
class SolutionTest {

	@Test
	void longestPalindromeSubseq() {
		Solution solution = new Solution();
		/**
		 * 输入：s = "bbbab"
		 * 输出：4
		 * 解释：一个可能的最长回文子序列为 "bbbb" 。
		 * 示例 2：
		 * <p>
		 * 输入：s = "cbbd"
		 * 输出：2
		 */
		Assertions.assertEquals(2, solution.longestPalindromeSubseq("cbbd"));
		Assertions.assertEquals(4, solution.longestPalindromeSubseq("bbbab"));
	}
}