package top.chenqwwq.leetcode.daily._20211109;

import java.util.Stack;

/**
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 * <p>
 *
 * @author chen
 * @date 2021-11-09
 **/
public class Solution {

	class Pair {
		char c;
		int cnt;

		public Pair(char c, int cnt) {
			this.c = c;
			this.cnt = cnt;
		}
	}

	int ans = -1;
	final int[] cnt = new int[26];
	final Stack<Pair> pairStack = new Stack<>();


	public int findMinStep(String board, String hand) {
		// 先统计手里的,使用一个数组标记手里的个数
		for (char c : hand.toCharArray()) {
			cnt[c - 'A']++;
		}
		// 使用栈保存当前未匹配的元素
		backtrace(board, 0, 0, cnt, pairStack);
		return ans;
	}

	public void backtrace(String board, int idx, int num, int[] cnts, Stack<Pair> stack) {
		// 统计到末尾
		if (idx >= board.length()) {
			if (stack.isEmpty()) {
				ans = ans == -1 ? num : Math.min(ans, num);
			}
			return;
		}

		// 当前统计数字
		char c = board.charAt(idx++);
		int cnt = 1;

		if (!stack.isEmpty()) {
			final Pair pair = stack.peek();
			if (pair.c == c) {
				stack.pop();
				cnt = (pair.cnt + 1) % 3;
			}
		}

		while (idx < board.length()) {
			final char curr = board.charAt(idx);
			if (c == curr) {
				cnt = (cnt + 1) % 3;
			} else if (cnt != 0) {
				// 填充
				final int need = 3 - cnt;
				if (cnts[c - 'A'] >= need) {
					cnts[c - 'A'] -= need;
					backtrace(board, idx, num + need, cnts, stack);
					cnts[c - 'A'] += need;
				}
				// 跳过
				stack.push(new Pair(c, cnt));
				backtrace(board, idx, num, cnts, stack);
			}
			idx++;
		}
		backtrace(board, idx + 1, num, cnts, stack);
	}

	public static void main(String[] args) {
		final int minStep = new Solution().findMinStep("WWRRBBWW", "WRBRW");
		System.out.println(minStep);
	}
}