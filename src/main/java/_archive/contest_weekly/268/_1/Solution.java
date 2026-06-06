package top.chenqwwq.leetcode.contest.weekly._268._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @date 2021/11/21
 **/
public class Solution {
	public int maxDistance(int[] colors) {
		Set<Integer> exist = new HashSet<>();
		final int n = colors.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (exist.contains(colors[i])) {
				continue;
			}
			exist.add(colors[i]);
			for (int j = n - 1; j > i; j--) {
				if (colors[j] != colors[i]) {
					ans = Math.max(ans, j - i );
					break;
				}
			}
		}
		return ans;
	}
}