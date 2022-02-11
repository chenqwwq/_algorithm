package top.chenqwwq.leetcode.lcof._2021._19;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/6/5
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void isMatch() {
		Assertions.assertTrue(solution.isMatch("bbbba", ".*a*a.*"));
		Assertions.assertTrue(solution.isMatch("", "c*c*"));
		Assertions.assertFalse(solution.isMatch("aa", "a"));
		Assertions.assertTrue(solution.isMatch("bbbba", ".*a*a"));
		Assertions.assertTrue(solution.isMatch("a", "a.*"));
		Assertions.assertTrue(solution.isMatch("bbbba", ".*a*a"));
		Assertions.assertTrue(solution.isMatch("a", "a*"));
		Assertions.assertTrue(solution.isMatch("a", "ab*"));
		Assertions.assertTrue(solution.isMatch("aa", "a*"));
		Assertions.assertTrue(solution.isMatch("ab", ".*"));
		Assertions.assertTrue(solution.isMatch("aab", "c*a*b"));
		Assertions.assertFalse(solution.isMatch("mississippi", "mis*is*p*."));
		Assertions.assertFalse(solution.isMatch("ab", ".*c"));
		Assertions.assertFalse(solution.isMatch("aaba", "ab*a*c*a"));
		Assertions.assertTrue(solution.isMatch("aaa", ".*"));
	}
}