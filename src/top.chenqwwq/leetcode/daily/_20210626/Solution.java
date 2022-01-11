package top.chenqwwq.leetcode.daily._20210626;

import java.util.*;

/**
 * 773. 滑动谜题
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 * <p>
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 * @author chen
 * @date 2021/6/26
 **/
public class Solution {
	final String target = "123450";

	public int slidingPuzzle(int[][] board) {
		// 尝试 BFS
		final String curr = getString(board);
		if (target.equals(curr)) {
			return 0;
		}

		Queue<String> queue = new LinkedList<>();
		Set<String> existed = new HashSet<>();
		queue.offer(curr);
		existed.add(curr);

		int ans = 0;
		while (!queue.isEmpty()) {
			ans++;
			final int size = queue.size();
			for (int i = 0; i < size; i++) {
				final String poll = queue.poll();
				for (String num : get(poll)) {
					if (target.equals(num)) {
						return ans;
					}
					if (existed.contains(num)) {
						continue;
					}
					existed.add(num);
					queue.offer(num);
				}
			}
		}
		return -1;
	}

	private List<String> get(String num) {
		List<String> ans = new ArrayList<>();
		final int idx = num.indexOf('0');
		int x = idx / 3, y = idx % 3;
		ans.add(update(num, idx, idx + ((x == 0 ? 3 : -3))));
		if (y < 2) {
			ans.add(update(num, idx, idx + 1));
		}
		if (y > 0) {
			ans.add(update(num, idx, idx - 1));
		}
		return ans;
	}

	private String update(String num, int i, int j) {
		final char[] chars = num.toCharArray();
		chars[i] ^= chars[j];
		chars[j] ^= chars[i];
		chars[i] ^= chars[j];
		return new String(chars);
	}

	private String getString(int[][] board) {
		StringBuilder ans = new StringBuilder();
		for (int[] arr : board) {
			for (int num : arr) {
				ans.append(num);
			}
		}
		return ans.toString();
	}
}