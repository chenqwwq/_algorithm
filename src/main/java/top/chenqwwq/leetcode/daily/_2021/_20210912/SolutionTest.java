package top.chenqwwq.leetcode.daily._2021._20210912;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/9/12
 **/
class SolutionTest {

	@Test
	void checkValidString() {
		Solution solution = new Solution();
		Assertions.assertFalse(solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
		Assertions.assertFalse(solution.checkValidString("()()(*)("));
	}
}