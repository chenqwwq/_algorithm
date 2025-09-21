package top.chenqwwq.leetcode.contest.weekly._271._3;

/**
 * @author chenbingxin
 * @date 2021/12/12
 **/
public class Solution {
	public int minimumRefill(int[] plants, int capacityA, int capacityB) {
		final int n = plants.length;
		int l = 0, r = n - 1, lc = capacityA, rc = capacityB;
		int ans = 0;
		while (l < r) {
			if (plants[l] <= lc) {
				lc -= plants[l];
			} else {
				lc = capacityA - plants[l];
				ans++;
			}
			l++;

			if (plants[r] <= rc) {
				rc -= plants[r];
			} else {
				rc = capacityB - plants[r];
				ans++;
			}
			r--;
		}
		if (l == r) {
			if (lc >= rc) {
				if (plants[l] > lc) {
					ans++;
				}
			} else {
				if (plants[r] > rc) {
					ans++;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().minimumRefill(new int[]{2, 2, 3, 3}, 5, 5);
	}
}