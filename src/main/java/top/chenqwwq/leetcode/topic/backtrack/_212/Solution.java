package top.chenqwwq.leetcode.topic.backtrack._212;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["o","a","a","n"],
 * *			["e","t","a","e"],
 * *			["i","h","k","r"],
 * *			["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 *
 * @author chen
 * @date 2021-05-19
 **/
public class Solution {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> ans = new ArrayList<>();
		for (String target : words) {
			if (search(board, target)) {
				ans.add(target);
			}
		}
		return ans;
	}

	public boolean search(char[][] board, String word) {
		final char[] chars = word.toCharArray();
		final int n = board.length, m = board[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(board, i, j, chars, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int x, int y, char[] word, int idx) {
		if (idx == word.length) {
			return true;
		}
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word[idx]) {
			return false;
		}
		board[x][y] = '0';
		final boolean res = dfs(board, x, y + 1, word, idx + 1)
				|| dfs(board, x, y - 1, word, idx + 1)
				|| dfs(board, x + 1, y, word, idx + 1)
				|| dfs(board, x - 1, y, word, idx + 1);
		board[x][y] = word[idx];
		return res;
	}
}