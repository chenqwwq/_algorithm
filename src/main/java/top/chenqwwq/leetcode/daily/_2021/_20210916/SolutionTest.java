package top.chenqwwq.leetcode.daily._2021._20210916;

import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-09-16
 **/
class SolutionTest {

	@Test
	void findWords() {
		Solution solution = new Solution();
		solution.findWords(new char[][]{
						{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
				},
				new String[]{"oath", "pea", "eat", "rain"});
	}
}