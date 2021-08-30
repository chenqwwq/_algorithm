package top.chenqwwq.leetcode.topic.dp.状压._1434;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chen
 * @date 2021/8/29
 **/
class SolutionTest {

	@Test
	void numberWays() {
		Solution solution = new Solution();

		Assertions.assertEquals(1, solution.numberWays(new ArrayList<List<Integer>>() {{
			add(Arrays.asList(3, 4));
			add(Arrays.asList(4, 5));
			add(Arrays.asList(5));
		}}));
	}

}