package top.chenqwwq.leetcode.topic.trie._212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	// 前缀树

	class TreeNode {
		Map<Character, TreeNode> childes = new HashMap<>();
		String word;

		public void insert(String word) {
			TreeNode root = this;
			final char[] chars = word.toCharArray();
			for (char c : chars) {
				TreeNode node = root.childes.get(c);
				if (node == null) {
					node = new TreeNode();
					root.childes.put(c, node);
				}
				root = node;
			}
			root.word = word;
		}
	}

	List<String> ans = new ArrayList<>();

	public List<String> findWords(char[][] board, String[] words) {
		// 构建前缀树
		TreeNode root = new TreeNode();
		for (String word : words) {
			root.insert(word);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				search(board, i, j, root);
			}
		}

		return ans;
	}

	public void search(char[][] board, int x, int y, TreeNode root) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '0') {
			return;
		}

		final char key = board[x][y];
		final TreeNode node = root.childes.get(key);
		if (node == null) {
			return;
		}
		board[x][y] = '0';
		if (node.word != null) {
			ans.add(node.word);
			node.word = null;
		}

		search(board, x + 1, y, node);
		search(board, x - 1, y, node);
		search(board, x, y + 1, node);
		search(board, x, y - 1, node);
		board[x][y] = key;
	}
}
































