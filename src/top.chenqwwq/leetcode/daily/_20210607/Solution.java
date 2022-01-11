package top.chenqwwq.leetcode.daily._20210607;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 100
 *
 * @author chen
 * @date 2021/6/7
 **/
public class Solution {

	// DFS 的基础实现
//	public int findTargetSumWays(int[] nums, int target) {
//		return dfs(nums, target, 0);
//	}
//
//	public int dfs(int[] nums, int target, int curr) {
//		System.out.printf("%d,%d\n", target, curr);
//		if (curr == nums.length) {
//			return target == 0 ? 1 : 0;
//		}
//		return dfs(nums, target - nums[curr], curr + 1) + dfs(nums, target + nums[curr], curr + 1);
//	}

//	Map<String, Integer> meme = new HashMap<>();
	// 记忆化搜索实现 去除重复的搜索
//	public int findTargetSumWays(int[] nums, int target) {
//		return dfs(nums, target, 0);
//	}
//
//	public int dfs(int[] nums, int target, int curr) {
//		if (curr == nums.length) {
//			return target == 0 ? 1 : 0;
//		}
//		final String key = target + "-" + curr;
//		if (meme.containsKey(key)) {
//			return meme.get(key);
//		}
//
//		final int ans = dfs(nums, target - nums[curr], curr + 1) + dfs(nums, target + nums[curr], curr + 1);
//		meme.put(key, ans);
//		return ans;
//	}

	// 二维dp
//	public int findTargetSumWays(int[] nums, int target) {
//		final int n = nums.length;
//		int[] sum = new int[n];
//		sum[0] = nums[0];
//		for (int i = 1; i < n; i++) {
//			sum[i] = nums[i] + sum[i - 1];
//		}
//
//		int max = sum[n - 1];
//		if (max < target) {
//			return 0;
//		}
//		// dp[i][j] 可能是+num[j]，也可能是-num[j]得到的
//		final int len = (max << 1) + 1;
//		int[][] dp = new int[n + 1][len];
//		dp[0][max] = 1;
//		for (int i = 1; i <= n; i++) {
//			int range = sum[i - 1], num = nums[i - 1];
//			for (int j = -range; j <= range; j++) {
//				final int idx1 = j + num + max, idx2 = j - num + max;
//				dp[i][j + max] = (idx1 < len ? dp[i - 1][idx1] : 0) + (idx2 >= 0 ? dp[i - 1][idx2] : 0);
//			}
//		}
//		return dp[n][target + max];
//	}

	// 空间优化为一维dp
	public int findTargetSumWays(int[] nums, int target) {
		final int n = nums.length;
		int[] sum = new int[n];
		sum[0] = nums[0];
		for (int i = 1; i < n; i++) {
			sum[i] = nums[i] + sum[i - 1];
		}

		int max = sum[n - 1];
		if (max < target) {
			return 0;
		}
		// dp[i][j] 可能是+num[j]，也可能是-num[j]得到的
		final int len = (max << 1) + 1;
		int[] dp = new int[len];
		dp[max] = 1;
		for (int i = 1; i <= n; i++) {
			int range = sum[i - 1], num = nums[i - 1];
			for (int j = -range; j <= range; j++) {
				final int idx1 = j + num + max, idx2 = j - num + max;
				dp[j + max] = (idx1 < len ? dp[idx1] : 0) + (idx2 >= 0 ? dp[idx2] : 0);
			}
		}
		return dp[target + max];
	}



}