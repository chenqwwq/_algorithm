package top.chenqwwq.leetcode.topic.backtrack._1467;

/**
 * 1467. 两个盒子中球的颜色数相同的概率
 * 桌面上有 2n 个颜色不完全相同的球，球上的颜色共有 k 种。给你一个大小为 k 的整数数组 balls ，其中 balls[i] 是颜色为 i 的球的数量。
 * <p>
 * 所有的球都已经 随机打乱顺序 ，前 n 个球放入第一个盒子，后 n 个球放入另一个盒子（请认真阅读示例 2 的解释部分）。
 * <p>
 * 注意：这两个盒子是不同的。例如，两个球颜色分别为 a 和 b，盒子分别为 [] 和 ()，那么 [a] (b) 和 [b] (a) 这两种分配方式是不同的（请认真阅读示例 1 的解释部分）。
 * <p>
 * 请计算「两个盒子中球的颜色数相同」的情况的概率。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：balls = [1,1]
 * 输出：1.00000
 * 解释：球平均分配的方式只有两种：
 * - 颜色为 1 的球放入第一个盒子，颜色为 2 的球放入第二个盒子
 * - 颜色为 2 的球放入第一个盒子，颜色为 1 的球放入第二个盒子
 * 这两种分配，两个盒子中球的颜色数都相同。所以概率为 2/2 = 1 。
 * 示例 2：
 * <p>
 * 输入：balls = [2,1,1]
 * 输出：0.66667
 * 解释：球的列表为 [1, 1, 2, 3]
 * 随机打乱，得到 12 种等概率的不同打乱方案，每种方案概率为 1/12 ：
 * [1,1 / 2,3], [1,1 / 3,2], [1,2 / 1,3], [1,2 / 3,1], [1,3 / 1,2], [1,3 / 2,1], [2,1 / 1,3], [2,1 / 3,1], [2,3 / 1,1], [3,1 / 1,2], [3,1 / 2,1], [3,2 / 1,1]
 * 然后，我们将前两个球放入第一个盒子，后两个球放入第二个盒子。
 * 这 12 种可能的随机打乱方式中的 8 种满足「两个盒子中球的颜色数相同」。
 * 概率 = 8/12 = 0.66667
 * 示例 3：
 * <p>
 * 输入：balls = [1,2,1,2]
 * 输出：0.60000
 * 解释：球的列表为 [1, 2, 2, 3, 4, 4]。要想显示所有 180 种随机打乱方案是很难的，但只检查「两个盒子中球的颜色数相同」的 108 种情况是比较容易的。
 * 概率 = 108 / 180 = 0.6 。
 * 示例 4：
 * <p>
 * 输入：balls = [3,2,1]
 * 输出：0.30000
 * 解释：球的列表为 [1, 1, 1, 2, 2, 3]。要想显示所有 60 种随机打乱方案是很难的，但只检查「两个盒子中球的颜色数相同」的 18 种情况是比较容易的。
 * 概率 = 18 / 60 = 0.3 。
 * 示例 5：
 * <p>
 * 输入：balls = [6,6,6,6,6,6]
 * 输出：0.90327
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= balls.length <= 8
 * 1 <= balls[i] <= 6
 * sum(balls) 是偶数
 * 答案与真实值误差在 10^-5 以内，则被视为正确答案
 *
 * @author chen
 * @date 2021-05-21
 **/
public class Solution {

	double used = 0, total = 0, colourCnt, ballCnt = 0;

	public double getProbability(int[] balls) {
		this.colourCnt = balls.length;
		for (int i : balls) {
			ballCnt += i;
		}
		total = getTotal(ballCnt, balls);
		bt(balls, 0, new int[balls.length], 0);
		return (double) used / total;
	}

	/**
	 * 以颜色做回溯
	 * 剪枝策略:
	 * 1. 大于球个数的一半直接减
	 */
	public void bt(int[] balls, int deep, int[] cVisited, int cnt) {
		if (cnt > ballCnt / 2) {
			return;
		}
		if (deep == colourCnt) {
			if (cnt == ballCnt / 2 && getColourCnt(balls) == getColourCnt(cVisited)) {
				used += getTotal(cnt, balls) * getTotal(cnt, cVisited);
			}
			return;
		}

		for (int i = 0; i <= balls[deep]; i++) {
			cVisited[deep] = i;
			balls[deep] -= i;
			bt(balls, deep + 1, cVisited, cnt + i);
			cVisited[deep] = 0;
			balls[deep] += i;
		}
	}

	private double getTotal(double ballCnt, int[] balls) {
		// 求方案总数
		double total = factorial(ballCnt);
		for (int i : balls) {
			if (i == 0 || i == 1) {
				continue;
			}
			total /= factorial(i);
		}
		return total;
	}

	private double factorial(double a) {
		double t = a - 1;
		while (t > 1) {
			a *= t--;
		}
		return a;
	}

	private int getColourCnt(int[] balls) {
		int colourCnt = 0;
		for (int i : balls) {
			if (i != 0) {
				colourCnt++;
			}
		}
		return colourCnt;
	}
}