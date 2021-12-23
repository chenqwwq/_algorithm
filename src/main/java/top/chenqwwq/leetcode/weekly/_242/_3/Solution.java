package top.chenqwwq.leetcode.weekly._242._3;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:
 *
 * @author chen
 * @date 2021/5/23
 **/
public class Solution {
	public boolean canReach(String s, int minJump, int maxJump) {
		if (s.charAt(s.length() - 1) != '0') {
			return false;
		}
		// 倒着推窗口
		return dfs(s.length() - 1, s.length() - 1, minJump, maxJump, s);
	}

	public boolean dfs(int left, int right, int minJump, int maxJump, String s) {
		if (right < 0) {
			return false;
		}

		if (left <= 0) {
			return true;
		}

		List<int[]> ranges = new ArrayList<>();
		int nl = -1, nw = -1;
		for (int i = Math.max(left, 0); i <= right; i++) {
			if (s.charAt(i) == '1') {
				continue;
			}
			if (nl == -1) {
				nl = i - maxJump;
				nw = i - minJump;
			} else {
				int tl = i - maxJump;
				int tr = i - minJump;
				if (tl < nw) {
					nl = Math.min(tl, nl);
					nw = Math.max(nw, tr);
				} else {
					ranges.add(new int[]{nl, nw});
					nl = tl;
					nw = tr;
				}
			}
		}
		ranges.add(new int[]{nl, nw});

		for (int[] i : ranges) {
			if (dfs(i[0], i[1], minJump, maxJump, s)) {
				return true;
			}
		}
		return false;
	}
}
