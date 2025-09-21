package top.chenqwwq.leetcode.topic.backtrack._1467;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

/**
 * @author chen
 * @date 2021-05-21
 **/
class SolutionTest {
	DecimalFormat df = new DecimalFormat("#.00000");

	@Test
	void getProbability() {
//		Assertions.assertEquals(1, new Solution().getProbability(new int[]{1, 1}));
//		Assertions.assertEquals(0.66667d, Double.parseDouble(df.format(new Solution().getProbability(new int[]{2, 1, 1}))));
//		Assertions.assertEquals(0.60000, Double.parseDouble(df.format(new Solution().getProbability(new int[]{1, 2, 1, 2}))));
//		Assertions.assertEquals(0.30000, Double.parseDouble(df.format(new Solution().getProbability(new int[]{3, 2, 1}))));
		Assertions.assertEquals(0.90327, Double.parseDouble(df.format(new Solution().getProbability(new int[]{6, 6, 6, 6, 6, 6}))));
	}
}