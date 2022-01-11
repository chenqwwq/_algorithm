package top.chenqwwq.leetcode.weekly._250._2;

/**
 * @author chen
 * @date 2021/7/18
 **/
public class Solution {
	public int addRungs(int[] rungs, int dist) {
		final int n = rungs.length;
		int cur = 0, target = 0, ans = 0;
		while (target < n) {
			boolean can = false;
			while (target < n && rungs[target] - cur <= dist) {
				can = true;
				target++;
			}
			if (can) {
				cur = rungs[target - 1];
			} else {
				final int diff = rungs[target] - cur;
				ans += diff / dist - (diff % dist == 0 ? 1 : 0);
				cur = rungs[target++];
			}
		}
		return ans;
	}
}