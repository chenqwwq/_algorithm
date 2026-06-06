package top.chenqwwq.leetcode.topic.trie._17_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 17.17. 多次搜索
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 * <p>
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 100000。
 * 你可以认为smalls中没有重复字符串。
 * 所有出现的字符均为英文小写字母。
 *
 * @author chen
 * @date 2021-05-24
 **/
public class Solution {

	static class TreeNode {
		Map<Character, TreeNode> childes = new HashMap<>();
		boolean isEnd;
		int idx;

		public void insert(String string, int idx) {
			TreeNode node = this;
			final char[] chars = string.toCharArray();
			for (char c : chars) {
				if (!node.childes.containsKey(c)) {
					final TreeNode child = new TreeNode();
					node.childes.put(c, child);
					node = child;
					continue;
				}
				node = node.childes.get(c);
			}

			node.isEnd = true;
			node.idx = idx;
		}
	}

	public int[][] multiSearch(String big, String[] smalls) {
		final int n = smalls.length;
		TreeNode root = new TreeNode();
		for (int i = 0; i < n; i++) {
			root.insert(smalls[i], i);
		}
		List<Integer>[] preAns = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			preAns[i] = new ArrayList<>();
		}
		final char[] chars = big.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			search(root, big, i, preAns);
		}
		int[][] ans = new int[n][];
		for (int i = 0; i < n; i++) {
			final int[] tmp = new int[preAns[i].size()];
			for (int j = 0; j < preAns[i].size(); j++) {
				tmp[j] = preAns[i].get(j);
			}
			ans[i] = tmp;
		}
		return ans;
	}

	public void search(TreeNode root, String big, int curr, List<Integer>[] preAns) {
		TreeNode node = root;
		int idx = curr;
		while (node != null && idx < big.length()) {
			final TreeNode treeNode = node.childes.get(big.charAt(idx++));
			if (treeNode == null) {
				return;
			}
			if (treeNode.isEnd) {
				preAns[treeNode.idx].add(curr);
			}
			node = treeNode;
		}
	}
}