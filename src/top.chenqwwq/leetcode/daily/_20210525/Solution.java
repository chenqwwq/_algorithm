package top.chenqwwq.leetcode.daily._20210525;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1787. 使所有区间的异或结果为零
 * 给你一个整数数组 nums和一个整数 k 。
 * 区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 * <p>
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 2000
 * 0 <= nums[i] < 210
 *
 * @author chen
 * @date 2021-05-25
 **/
public class Solution {
	public int minChanges(int[] nums, int k) {
		int[][] dp = new int[k][1024];
		int[] hash = new int[1024];
		int[] pre = new int[k];
		final int n = nums.length;

		for (int i = 0; i < n; i += k) {
			hash[nums[i]]++;
		}
		pre[0] = Integer.MAX_VALUE;
		for (int i = 0; i < 1024; i++) {
			dp[0][i] = n / k + (n % k == 0 ? 0 : 1) - hash[i];
			pre[0] = Math.min(dp[0][i], pre[0]);
		}

		for (int i = 1; i < k; i++) {
			int cnt = (i < (n % k) ? 1 : 0) + n / k;
			Arrays.fill(hash, 0);
			Set<Integer> numSet = new HashSet<>();
			for (int j = i; j < n; j += k) {
				hash[nums[j]]++;
				numSet.add(nums[j]);
			}
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < 1024; j++) {
				dp[i][j] = pre[i - 1] + cnt;
				for (int num : numSet) {
					dp[i][j] = Math.min(dp[i][j], cnt - hash[num] + dp[i - 1][j ^ num]);
				}
				min = Math.min(min, dp[i][j]);
			}
			pre[i] = min;
		}

		return dp[k - 1][0];
	}
}