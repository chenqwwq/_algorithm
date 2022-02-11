package top.chenqwwq.leetcode.topic.dp._1799;

import java.util.HashMap;
import java.util.Map;

/**
 * 1799. N 次操作后的最大分数和
 * 给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。
 * <p>
 * 在第 i 次操作时（操作编号从 1 开始），你需要：
 * <p>
 * 选择两个元素 x 和 y 。
 * 获得分数 i * gcd(x, y) 。
 * 将 x 和 y 从 nums 中删除。
 * 请你返回 n 次操作后你能获得的分数和最大为多少。
 * <p>
 * 函数 gcd(x, y) 是 x 和 y 的最大公约数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最优操作是：
 * (1 * gcd(1, 2)) = 1
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,6,8]
 * 输出：11
 * 解释：最优操作是：
 * (1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,6]
 * 输出：14
 * 解释：最优操作是：
 * (1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 7
 * nums.length == 2 * n
 * 1 <= nums[i] <= 106
 *
 * @author chen
 * @date 2021/5/20
 **/
public class Solution {

	int ans = 1, n;
	int[][] gcds = new int[15][15];
	Map<Integer, Integer> hash = new HashMap<>();

	public int maxScore(int[] nums) {
		n = nums.length >> 1;

		// 预处理 gcd
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				gcds[i][j] = gcds[j][i] = gcd(i, j);
			}
		}

		return ans;
	}

	/**
	 * 选择的两个数字也不要求顺序,选择的所有数队也不要求顺序
	 */
	public void dfs(int[] nums, boolean[] visit) {

	}


	/**
	 * 辗转相除法求 gcd
	 */
	private int gcd(int x, int y) {
		if (x == y) {
			return x;
		}

		final int t = x % y;
		return t == 0 ? y : gcd(y, t);
	}
}



















