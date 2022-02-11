package top.chenqwwq.leetcode.daily._20210523;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.util.Arrays;

/**
 * 1707. 与数组中元素的最大异或值
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * <p>
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * <p>
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 *
 * @author chen
 * @date 2021/5/23
 **/
public class Solution {

	class TreeNode {
		TreeNode[] childes = new TreeNode[2];
		int cnt;

		public void insert(int num) {
			TreeNode node = this;
			do {
				int idx = num & 1;
				if (node.childes[idx] == null) {
					node.childes[idx] = new TreeNode();
				}
				num >>= 1;
				node = node.childes[idx];
			} while (num != 0);
			node.cnt++;

		}
	}



	public int[] maximizeXor(int[] nums, int[][] queries) {
		TreeNode root = new TreeNode();
		for (int num : nums) {
			root.insert(num);
		}
		final int qc = queries.length;
		int[] ans = new int[qc];
		for (int i = 0; i < qc; i++) {
			ans[i] = search(root, queries[i][0], queries[i][1], 0, 0);
		}
		return ans;
	}

	/**
	 * 返回小于 curr 的所有数的疑惑和
	 */
	public int search(TreeNode root, int x, int m, int curr, int level) {
		if ((root.childes[0] == null && root.childes[1] == null) || (curr | (1 << level)) > m) {
			return root.cnt > 0 ? x : -1;
		}

		int num1 = -1, num2 = -1, num3 = -1;
		// 当前点是终点
		if (root.cnt > 0) {
			num3 = x;
		}
		// 继续向下搜索
		if (root.childes[0] != null) {
			num1 = search(root.childes[0], x, m, curr, level + 1);
		}
		if (root.childes[1] != null) {
			// 当前下标的计算
			num2 = search(root.childes[1], x ^ 1 << level, m, curr | (1 << level), level + 1);
		}
		return Math.max(num1, Math.max(num2, num3));
	}
}