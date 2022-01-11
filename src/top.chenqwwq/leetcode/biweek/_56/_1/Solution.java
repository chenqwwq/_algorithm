package top.chenqwwq.leetcode.biweek._56._1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chen
 * @date 2021/7/10
 **/
public class Solution {
	public int countTriples(int n) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			set.add(i * i);
		}

		int ans = 0;
		for (int num : set) {
			for (int a : set) {
				if (num == a) {
					continue;
				}
				if (set.contains(num - a)) {
					ans++;
				}
			}
		}
		return ans;
	}
}