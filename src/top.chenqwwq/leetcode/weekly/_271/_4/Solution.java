package top.chenqwwq.leetcode.weekly._271._4;

/**
 * @author chenbingxin
 * @date 2021/12/12
 **/
public class Solution {

	public int maxTotalFruits(int[][] fruits, int startPos, int k) {
		int max = 0;

		for (int i = 0, j = i, sum = 0; i < fruits.length; sum -= fruits[i++][1]) {
			while (j < fruits.length && 2 * Math.max(0, startPos - fruits[i][0]) + Math.max(0, fruits[j][0] - startPos) <= k) {
				max = Math.max(max, sum += fruits[j++][1]);
			}
		}
		for (int i = fruits.length - 1, j = i, sum = 0; i >= 0; sum -= fruits[i--][1]) {
			while (j >= 0 && 2 * Math.max(0, fruits[i][0] - startPos) + Math.max(0, startPos - fruits[j][0]) <= k) {
				max = Math.max(max, sum += fruits[j--][1]);
			}
		}
		return max;
	}
}