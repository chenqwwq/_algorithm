package top.chenqwwq.leetcode.topic.backtrack._1140;

import java.util.Arrays;

/**
 * 1140. 石子游戏 II
 * 亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * <p>
 * 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。
 * <p>
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * <p>
 * 游戏一直持续到所有石子都被拿走。
 * <p>
 * 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：piles = [2,7,9,4,4]
 * 输出：10
 * 解释：
 * 如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
 * 如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
 * 所以我们返回更大的 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 100
 * 1 <= piles[i] <= 10 ^ 4
 *
 * @author chen
 * @date 2021/5/22
 **/
public class Solution {
	public static void main(String[] args) {
		final int i = new Solution().stoneGameII(new int[]{2, 7, 9, 4, 2, 4, 7, 1, 2, 5, 1});
		System.out.println(i);
	}

	// TODO: 记忆化搜索未完成
	public int stoneGameII(int[] piles) {
		final int n = piles.length;
		int[][] memo = new int[n][n + 1];

		// 计算前缀和
		int[] pre = new int[n + 1];
		pre[0] = 0;
		for (int i = 0; i < n; i++) {
			pre[i + 1] = pre[i] + piles[i];
		}

		return bt(pre, memo, 1, 1, true);
	}

	private int bt(int[] pre, int[][] memo, int idx, int cnt, boolean isA) {
		if (idx >= pre.length) {
			return 0;
		}

		if (memo[idx][cnt] != 0) {
			return memo[idx][cnt];
		}

		int max = isA ? 0 : Integer.MIN_VALUE;
		for (int i = 0; i < cnt && idx + i < pre.length; i++) {
			max = Math.max(max, isA
					? pre[idx + i] - pre[idx - 1] + bt(pre, memo, idx + i + 1, 2 * Math.max(i + 1, cnt / 2), false)
					: -bt(pre, memo, idx + i + 1, 2 * Math.max(i + 1, cnt / 2), true));
		}

		final int i = isA ? max : -max;

		return i;
	}
}


























