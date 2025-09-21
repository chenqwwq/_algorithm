package top.chenqwwq.leetcode.topic.dp._1043;

/**
 * 1043. 分隔数组以得到最大和
 * 给你一个整数数组 arr，请你将该数组分隔为长度最多为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 * <p>
 * 返回将数组分隔变换后能够得到的元素最大和。
 * <p>
 * <p>
 * <p>
 * 注意，原数组和分隔后的数组对应顺序应当一致，也就是说，你只能选择分隔数组的位置而不能调整数组中的顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：
 * 因为 k=3 可以分隔成 [1,15,7] [9] [2,5,10]，结果为 [15,15,15,9,10,10,10]，和为 84，是该数组所有分隔变换后元素总和最大的。
 * 若是分隔成 [1] [15,7,9] [2,5,10]，结果就是 [1, 15, 15, 15, 10, 10, 10] 但这种分隔方式的元素总和（76）小于上一种。
 * 示例 2：
 * <p>
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 * 示例 3：
 * <p>
 * 输入：arr = [1], k = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 *
 * @author chen
 * @date 2021/5/22
 **/
public class Solution {
	public int maxSumAfterPartitioning(int[] arr, int k) {
		final int n = arr.length;
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int max = 0, ans = 0;
			for (int cnt = 0; cnt < k && i - cnt >= 0; cnt++) {
				max = Math.max(arr[i - cnt], max);
				ans = Math.max(ans, dp[i - cnt] + max * (cnt + 1));
			}
			dp[i + 1] = ans;
		}
		return dp[n];
	}
}
