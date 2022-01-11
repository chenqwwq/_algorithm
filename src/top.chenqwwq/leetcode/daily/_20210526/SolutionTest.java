package top.chenqwwq.leetcode.daily._20210526;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/26
 **/
class SolutionTest {
	Solution solution = new Solution();

	@Test
	void reverseParentheses() {
		Assertions.assertEquals("ndyfvefltvecb", solution.reverseParentheses("n(ev(t)((()lfevf))yd)cb()"));
		Assertions.assertEquals("tauswa", solution.reverseParentheses("ta()usw((((a))))"));
		Assertions.assertEquals("eqkh", solution.reverseParentheses("((eqk((h))))"));
		Assertions.assertEquals("dcba", solution.reverseParentheses("(abcd)"));
		Assertions.assertEquals("iloveu", solution.reverseParentheses("(u(love)i)"));
		Assertions.assertEquals("leetcode", solution.reverseParentheses("(ed(et(oc))el)"));
		Assertions.assertEquals("apmnolkjihgfedcbq", solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
	}
}