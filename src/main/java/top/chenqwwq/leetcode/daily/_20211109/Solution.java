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

	static class Pair {
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

		// 当前统计位
		char c = board.charAt(idx++);
		int cnt = 1;

		Pair pair = null;
		// 尝试和栈中数组合并消除
		// 可以消除直接进入下一个不同节点
		if (!stack.isEmpty()) {
			if (stack.peek().c == c) {
				pair = stack.pop();
				if ((cnt += pair.cnt) >= 3) {
					while (idx < board.length() && board.charAt(idx) == c) {
						idx++;
					}
					backtrace(board, idx, num, cnts, stack);
					stack.push(pair);
					return;
				}
			}
		}

		// 往后遍历找到相同的元素
		while (idx < board.length()) {
			final char curr = board.charAt(idx);
			if (c != curr) {
				break;
			}
			// 大于三个则直接消除掉全部
			if (++cnt >= 3) {
				while (idx < board.length() && board.charAt(idx) == c) {
					idx++;
				}
				backtrace(board, idx, num, cnts, stack);
				if (pair != null) {
					stack.push(pair);
				}
				return;
			}
			idx++;
		}

		// 找到了不同的元素
		// 1. 填充对应的数量
		final int need = 3 - cnt;
		if (cnts[c - 'A'] >= need) {
			cnts[c - 'A'] -= need;
			backtrace(board, idx, num + need, cnts, stack);
			cnts[c - 'A'] += need;
		}

		// 2. 跳过不填充
		stack.push(new Pair(c, cnt));
		backtrace(board, idx, num, cnts, stack);
		stack.pop();
		if (pair != null) {
			stack.push(pair);
		}
	}
}