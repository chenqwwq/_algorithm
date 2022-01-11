package top.chenqwwq.leetcode.biweek._66._3;

/**
 * @author chenbingxin
 * @date 2021/11/28
 **/
public class Solution {
	public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
		int ans = 0;
		if(startPos[0] != homePos[0]) {
			for (int i = Math.min(startPos[0], homePos[0]) + 1; i < Math.max(startPos[0], homePos[0]); i++) {
				ans += rowCosts[i];
			}
			ans += rowCosts[homePos[0]];
		}

		if(startPos[1] != homePos[1]){
			for (int i = Math.min(startPos[1], homePos[1]) + 1; i < Math.max(startPos[1], homePos[1]); i++) {
				ans += colCosts[i];
			}
			ans += colCosts[homePos[1]];
		}
		return ans;
	}
}