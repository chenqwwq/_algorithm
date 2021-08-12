package top.chenqwwq.leetcode.lcof._2021._60;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * <p>
 * <p>
 * <p>
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * <p>
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * @author chen
 * @date 2021-08-12
 **/
public class Solution {
	public double[] dicesProbability(int n) {
		if (n == 1) {
			double[] ans = new double[6];
			Arrays.fill(ans, 1.0 / 6.0);
			return ans;
		}
		final int len = n * 5 + 1;
		double[] ans = new double[len];
		final double[] doubles = dicesProbability(n - 1);
		for (int i = 0; i < doubles.length; i++) {
			for (int j = 0; j < 6; j++) {
				ans[i + j] += doubles[i] / 6.0d;
			}
		}
		return ans;
	}
}