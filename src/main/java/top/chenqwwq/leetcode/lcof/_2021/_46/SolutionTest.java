package top.chenqwwq.leetcode.lcof._2021._46;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021-07-27
 **/
class SolutionTest {

	@Test
	void translateNum() {
		Solution solution = new Solution();
		Assertions.assertEquals(2,solution.translateNum(25));
	}
}