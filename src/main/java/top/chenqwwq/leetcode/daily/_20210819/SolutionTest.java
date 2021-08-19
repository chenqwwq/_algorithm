package top.chenqwwq.leetcode.daily._20210819;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/8/19
 **/
class SolutionTest {

	@Test
	void reverseVowels() {
		Solution solution = new Solution();
		Assertions.assertEquals("holle",solution.reverseVowels("hello"));
		Assertions.assertEquals("leotcede",solution.reverseVowels("leetcode"));
	}
}