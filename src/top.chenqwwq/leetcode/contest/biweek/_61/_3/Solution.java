package top.chenqwwq.leetcode.contest.biweek._61._3;

import java.util.*;

/**
 * @author chen
 * @date 2021/9/18
 **/
public class Solution {
	public int[] findOriginalArray(int[] changed) {
		if (changed == null || changed.length < 2) {
			return new int[]{};
		}
		final int n = changed.length;
		int[] ans = new int[n >> 1];
		int idx = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : changed) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		final List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		for (int num : keys) {
			int cnt;
			if ((cnt = map.get(num)) <= 0) {
				continue;
			}
			final int num2 = num * 2;
			if (num2 == num) {
				if((cnt & 1) == 1){
					return new int[]{};
				}
				for (int i = 0; i < cnt >> 1; i++) {
					ans[idx++] = num;
				}
				continue;
			}
			if (map.getOrDefault(num2, 0) < cnt) {
				return new int[]{};
			}
			map.put(num2, map.get(num2) - cnt);
			for (int i = 0; i < cnt; i++) {
				ans[idx++] = num;
			}
		}
		return ans;
	}


	public static void main(String[] args) {

		new Solution().findOriginalArray(new int[]{0, 0, 0, 0});
	}
}