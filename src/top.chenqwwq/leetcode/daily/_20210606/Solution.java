package top.chenqwwq.leetcode.daily._20210606;

/**
 * 474. 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 *
 * @author chen
 * @date 2021/6/6
 **/
public class Solution {
	public int findMaxForm(String[] strs, int m, int n) {
		final int l = strs.length;
		// 两种状态的转移
		// dp[i][j] 表示 i 个0，j个1
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= l; i++) {
			int cnt1 = getOne(strs[i - 1]), cnt0 = strs[i - 1].length() - cnt1;
			for (int q = m; q >= cnt0; q--) {
				for (int p = n; p >= cnt1; p--) {
					dp[q][p] = Math.max(dp[q][p], dp[q - cnt0][p - cnt1] + 1);
				}
			}
		}
		return dp[m][n];
	}

	public int getOne(String word) {
		int ans = 0;
		for (char c : word.toCharArray()) {
			if (c == '1') {
				ans++;
			}
		}
		return ans;
	}
}