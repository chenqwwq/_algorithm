package top.chenqwwq.leetcode.topic.dp._1799;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/5/20
 **/
class SolutionTest {

	@Test
	void maxScore() {
		Assertions.assertEquals(249, new Solution().maxScore(new int[]{12, 34, 80, 64, 5, 6, 25, 6, 8, 19, 2, 10, 20, 2}));
//		Assertions.assertEquals(1, new Solution().maxScore(new int[]{1, 2}));
		Assertions.assertEquals(11, new Solution().maxScore(new int[]{3, 4, 6, 8}));
//		Assertions.assertEquals(14, new Solution().maxScore(new int[]{1, 2, 3, 4, 5, 6}));
	}
}