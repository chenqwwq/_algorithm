package top.chenqwwq.leetcode.daily._20210916;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021-09-16
 **/
public class Solution {
	// 字典树实现

	class TreeNode {
		Map<Character, TreeNode> childs = new HashMap<>();
		String word;

		public void insert(String word) {
			TreeNode curr = this;
			for (int i = 0; i < word.length(); i++) {
				final char key = word.charAt(i);
				TreeNode child = curr.childs.get(key);
				if (child == null) {
					child = new TreeNode();
					curr.childs.put(key, child);
				}
				curr = child;
			}
			curr.word = word;
		}
	}

	final List<String> ans = new ArrayList<>();
	char[][] board;
	int n, m;
	int[] cx = new int[]{0, 0, 1, -1};
	int[] cy = new int[]{1, -1, 0, 0};

	public List<String> findWords(char[][] _board, String[] words) {
		if (words == null || words.length == 0) {
			return ans;
		}
		board = _board;
		n = board.length;
		m = board[0].length;
		// 初始化字典树
		final TreeNode root = new TreeNode();
		for (String word : words) {
			root.insert(word);
		}
		final boolean[][] exists = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				search(root, i, j, exists);
			}
		}
		return ans;
	}

	public void search(TreeNode root, int i, int j, boolean[][] exists) {
		if (i < 0 || i >= n || j < 0 || j >= m || exists[i][j]) {
			return;
		}
		final TreeNode child = root.childs.get(board[i][j]);
		if (child == null) {
			return;
		}
		if (child.word != null) {
			ans.add(child.word);
			child.word = null;
		}
		exists[i][j] = true;
		for (int c = 0; c < 4; c++) {
			search(child, i + cx[c], j + cy[c], exists);
		}
		exists[i][j] = false;
	}
}