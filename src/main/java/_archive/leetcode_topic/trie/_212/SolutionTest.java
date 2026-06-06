package top.chenqwwq.leetcode.topic.trie._212;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-05-19
 **/
class SolutionTest {


	@Test
	void findWords() {
		Assertions.assertArrayEquals(new String[]{"oa", "oaa"}, new Solution().findWords(new char[][]{
				{'o', 'a', 'b', 'n'},
				{'o', 't', 'a', 'e'},
				{'a', 'h', 'k', 'r'},
				{'a', 'f', 'l', 'v'}
		}, new String[]{"oa", "oaa"}).toArray(new String[0]));

		Assertions.assertArrayEquals(new String[]{"a"}, new Solution().findWords(new char[][]{
				{'a'}
		}, new String[]{"a", "b", "c"}).toArray(new String[0]));

		Assertions.assertArrayEquals(new String[]{"abc"}, new Solution().findWords(new char[][]{
				{'a'},
				{'b'},
				{'c'}
		}, new String[]{"abc"}).toArray(new String[0]));

		Assertions.assertArrayEquals(new String[]{}, new Solution().findWords(new char[][]{
				{'a', 'a'},
		}, new String[]{"aaa"}).toArray(new String[0]));

		Assertions.assertArrayEquals(new String[]{"oath", "eat"}, new Solution().findWords(new char[][]{
				{'o', 'a', 'a', 'n'},
				{'e', 't', 'a', 'e'},
				{'i', 'h', 'k', 'r'},
				{'i', 'f', 'l', 'v'}
		}, new String[]{"oath", "pea", "eat", "rain"}).toArray(new String[0]));
	}
}