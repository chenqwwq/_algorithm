package top.chenqwwq.leetcode.daily._20210612;


import java.util.*;

/**
 * 1449. 数位成本和为目标值的最大数字
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * <p>
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * <p>
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
 * 输出："7772"
 * 解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要求的数字，但 "7772" 是较大的数字。
 * 数字     成本
 * 1  ->   4
 * 2  ->   3
 * 3  ->   2
 * 4  ->   5
 * 5  ->   6
 * 6  ->   7
 * 7  ->   2
 * 8  ->   5
 * 9  ->   5
 * 示例 2：
 * <p>
 * 输入：cost = [7,6,5,5,5,6,8,7,8], target = 12
 * 输出："85"
 * 解释：添加数位 '8' 的成本是 7 ，添加数位 '5' 的成本是 5 。"85" 的成本为 7 + 5 = 12 。
 * 示例 3：
 * <p>
 * 输入：cost = [2,4,6,2,4,6,4,4,4], target = 5
 * 输出："0"
 * 解释：总成本是 target 的条件下，无法生成任何整数。
 * 示例 4：
 * <p>
 * 输入：cost = [6,10,15,40,40,40,40,40,40], target = 47
 * 输出："32211"
 * <p>
 * <p>
 * 提示：
 * <p>
 * cost.length == 9
 * 1 <= cost[i] <= 5000
 * 1 <= target <= 5000
 *
 * @author chen
 * @date 2021/6/12
 **/
public class Solution {

	public String largestNumber(int[] cost, int target) {
		// 在分数相同的情况下选择尽量大的数字，相同的选择较小的数字，数位比较多

		// 成本相同的情况下去除代表数字较小的
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < cost.length; i++) {
			hash.put(cost[i], i + 1);
		}

		final ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(hash.entrySet());
		// 按照成本倒序
		entries.sort(Map.Entry.comparingByValue());
		final int n = entries.size();

		// 一开始希望直接拼接字符串，但是插入的时候不好处理
		String[] dp = new String[target + 1];
		Arrays.fill(dp, "#");
		dp[0] = "";

		// 选择成本
		for (int i = n - 1; i >= 0; i--) {
			final Map.Entry<Integer, Integer> entry = entries.get(i);
			// 对应数字和成本
			int c = entry.getKey(), num = entry.getValue();
			// 成本过高直接淘汰
			if (c > target) {
				continue;
			}
			for (int d = c; d <= target; d++) {
				if ("#".equals(dp[d - c])) {
					continue;
				}
				dp[d] = isMore(dp[d - c] + num, dp[d]) ? dp[d - c] + num : dp[d];
			}
		}
		return "#".equals(dp[target]) ? "0" : dp[target];
	}

	public boolean isMore(String a, String b) {
		if (a.length() > b.length()) {
			return true;
		} else if (a.length() < b.length()) {
			return false;
		} else {
			return a.compareTo(b) > 0;
		}
	}
}