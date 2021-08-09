package top.chenqwwq.leetcode.daily._20210731;

import top.chenqwwq.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * @author chen
 * @date 2021/7/31
 **/
public class Solution {
	TreeMap<Integer, List<int[]>> ans = new TreeMap<>();


	public List<List<Integer>> verticalTraversal(TreeNode root) {

		dfs(root, 0, 0);
		List<List<Integer>> res = new ArrayList<>();
		while (!ans.isEmpty()) {
			final List<int[]> value = ans.pollFirstEntry().getValue();
			value.sort(((Comparator<int[]>) (o1, o2) -> Integer.compare(o1[0], o2[0]))
					.thenComparing((o1, o2) -> Integer.compare(o1[1], o2[1])));
			List<Integer> temp = new ArrayList<>();
			for (int[] v : value) {
				temp.add(v[1]);
			}
			res.add(temp);
		}
		return res;
	}


	private void dfs(TreeNode node, int cur, int level) {
		if (node == null) {
			return;
		}
		final List<int[]> orDefault = ans.getOrDefault(cur, new ArrayList<>());
		orDefault.add(new int[]{level, node.val});
		ans.put(cur, orDefault);
		dfs(node.left, cur - 1, level + 1);
		dfs(node.right, cur + 1, level + 1);
	}

}
