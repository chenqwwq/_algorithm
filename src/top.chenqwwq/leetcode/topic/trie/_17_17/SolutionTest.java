package top.chenqwwq.leetcode.topic.trie._17_17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-24
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void multiSearch() {
		Assertions.assertArrayEquals(new int[][]{
				{}, {}, {}
		}, solution.multiSearch("", new String[]{"a", "b", "c"}));
		Assertions.assertArrayEquals(new int[][]{
				{1, 4}, {8}, {}, {3}, {1, 4, 7, 10}, {5}
		}, solution.multiSearch("mississippi", new String[]{"is", "ppi", "hi", "sis", "i", "ssippi"}));
	}
}