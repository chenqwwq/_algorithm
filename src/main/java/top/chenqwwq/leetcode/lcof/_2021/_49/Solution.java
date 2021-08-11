package top.chenqwwq.leetcode.lcof._2021._49;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 *
 * @author chen
 * @date 2021-08-09
 **/
public class Solution {
	private int[] factors = {2, 3, 5};

	public int nthUglyNumber(int n) {
		int[] dp = new int[n], fn = {0, 0, 0};
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int f0 = dp[fn[0]] * factors[0], f1 = dp[fn[1]] * factors[1], f2 = dp[fn[2]] * factors[2];
			dp[i] = min(f0, f1, f2);
			if (dp[i] == f0) {
				fn[0]++;
			}
			if (dp[i] == f1) {
				fn[1]++;
			}
			if (dp[i] == f2) {
				fn[2]++;
			}
		}
		return dp[n - 1];
	}

	private int min(int a, int b, int c) {
		return Integer.min(a, Integer.min(b, c));
	}

//	public int nthUglyNumber(int n) {
//		// 优先级队列
//		int cnt = 1, ans = 1;
//		PriorityQueue<Long> queue = new PriorityQueue<>();
//		Set<Long> exists = new HashSet<>();
//		queue.offer(1L);
//		exists.add(1L);
//		while (cnt++ <= n) {
//			final Long num = queue.poll();
//			ans = num.intValue();
//			for (int factor : factors) {
//				long temp = factor * num;
//				if (exists.add(temp)) {
//					queue.offer(temp);
//				}
//			}
//		}
//		return ans;
//	}
}