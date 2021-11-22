package top.chenqwwq.leetcode.week._268._2;

/**
 * @author chen
 * @date 2021/11/21
 **/
public class Solution {
	public int wateringPlants(int[] plants, int capacity) {
		int ans = 0;
		final int n = plants.length;
		int curr = capacity;
		for (int i = 0; i < n; i++) {
			if (curr >= plants[i]) {
				curr -= plants[i];
				ans++;
			} else if (capacity >= plants[i]) {
				ans += 2 * i + 1;
				curr = capacity - plants[i];
			} else {
				return -1;
			}
		}
		return ans;
	}
}