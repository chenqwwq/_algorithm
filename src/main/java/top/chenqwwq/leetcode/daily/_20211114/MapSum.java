package top.chenqwwq.leetcode.daily._20211114;

/**
 * @author chen
 * @date 2021/11/14
 **/
public class MapSum {

	static class TrieNode {
		TrieNode[] map = new TrieNode[26];
		int cnt = 0;

		public TrieNode() {
		}
	}

	TrieNode ROOT;

	public MapSum() {
		ROOT = new TrieNode();
	}

	public void insert(String key, int val) {
		TrieNode curr = ROOT;
		for (char c : key.toCharArray()) {
			final int idx = c - 'a';
			if (curr.map[idx] != null) {
				curr = curr.map[idx];
			} else {
				final TrieNode newNode = new TrieNode();
				curr.map[idx] = newNode;
				curr = newNode;
			}
		}
		curr.cnt = val;
	}

	public int sum(String prefix) {
		TrieNode curr = ROOT;
		for (char c : prefix.toCharArray()) {
			final int idx = c - 'a';
			if (curr.map[idx] != null) {
				curr = curr.map[idx];
			} else {
				return 0;
			}
		}
		return dfs(curr);
	}

	public int dfs(TrieNode node) {
		int ans = 0;
		if (node == null) {
			return ans;
		}
		ans += node.cnt;
		for (TrieNode n : node.map) {
			ans += dfs(n);
		}
		return ans;
	}
}