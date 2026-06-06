package top.chenqwwq.leetcode.daily._2021._20211220;

import java.util.Arrays;

/**
 * @author chenbingxin
 * @date 2021/12/20
 **/
public class Solution {
	public int findRadius(int[] houses, int[] heaters) {
		final int n = houses.length, m = heaters.length;
		Arrays.sort(houses);
		Arrays.sort(heaters);

		if (heaters.length == 1) {
			return Math.max(heaters[0] - houses[0], houses[n - 1] - heaters[0]);
		}

		int ans = 0, cur = 1;
		for (int house : houses) {
			while (cur < m) {
				if (heaters[cur] >= house) {
					break;
				}
				cur++;
			}
			int x = cur < m ? abs(heaters[cur] - house) : Integer.MAX_VALUE, y = abs(heaters[cur - 1] - house);
			ans = Math.max(ans, Math.min(x, y));
		}
		return ans;
	}

	private int abs(int num) {
		return Math.abs(num);
	}

	public static void main(String[] args) {
//		[1,1,1,1,1,1,999,999,999,999,999]
//[499,500,501]
		new Solution().findRadius(new int[]{1, 1, 1, 1, 1, 1, 999, 999, 999, 999, 999}, new int[]{488, 500, 501});
	}
}
