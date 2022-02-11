package top.chenqwwq.leetcode.biweek._67._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author chenbingxin
 * @date 2021/12/11
 **/
public class Solution {
	public List<Integer> goodDaysToRobBank(int[] security, int time) {
		List<Integer> ans = new ArrayList<>();
		final int n = security.length;
		if (time == 0) {
			for (int i = 0; i < n; i++) {
				ans.add(i);
			}
			return ans;
		}
		int[] pre = new int[n + 1], sub = new int[n + 1];
		for (int i = 0; i < n; i++) {
			pre[i + 1] = pre[i] + (i + 1 < n && security[i] >= security[i + 1] ? 1 : 0);
			sub[n - i - 1] = sub[n - i] + (n - i - 2 >= 0 && security[n - i - 1] >= security[n - i - 2] ? 1 : 0);
		}
		for (int i = time; i < n - time; i++) {
			if (pre[i] - pre[i - time] == time && sub[i + 1] - sub[i + time + 1] == time) {
				ans.add(i);
			}
		}
		return ans;
	}
}