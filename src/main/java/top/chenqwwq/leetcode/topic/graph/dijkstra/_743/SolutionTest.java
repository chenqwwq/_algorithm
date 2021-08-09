package top.chenqwwq.leetcode.topic.graph.dijkstra._743;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/8/6
 **/
class SolutionTest {

	@Test
	void networkDelayTime() {
		Solution solution = new Solution();
		Assertions.assertEquals(2, solution.networkDelayTime(new int[][]{
				{2, 1, 1}, {2, 3, 1}, {3, 4, 1}
		}, 4, 2));
	}

}