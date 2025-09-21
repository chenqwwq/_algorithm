package top.chenqwwq.leetcode.contest.weekly._254._4;

import java.util.Arrays;

/**
 * @author chen
 * @date 2021/8/15
 **/
public class Solution {

	class DisjointSet {
		/**
		 * 底层保存形式,tree[i]表示第i个节点的父节点,-1表示为顶级节点
		 */
		private int[] tree;

		public DisjointSet(int n) {
			this.tree = new int[n];
			Arrays.fill(tree, -1);
		}

		public int root(int n) {
			// 找到x节点的根节点
			int node = n;
			while (tree[node] != -1) {
				node = tree[node];
			}
			return node;
		}

		public void union(int x, int y) {
			int xRoot = root(x);
			int yRoot = root(y);
			if (xRoot != yRoot) {
				tree[xRoot] = yRoot;
			}
		}


	}

	public int latestDayToCross(int row, int col, int[][] cells) {
		return -1;
	}
}