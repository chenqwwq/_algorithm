package top.chenqwwq.leetcode.daily._2021._20210625;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 *
 * @author chen
 * @date 2021-06-25
 **/
public class Solution {
	public int openLock(String[] deadends, String target) {
		if ("0000".equals(target)) {
			return 0;
		}
		Set<Integer> hash = new HashSet<>();
		for (String deadend : deadends) {
			if ("0000".equals(deadend)) {
				return -1;
			}
			hash.add(Integer.valueOf(deadend));
		}
		int targetNum = Integer.parseInt(target);

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		Set<Integer> exist = new HashSet<>();
		exist.add(0);

		int ans = 0;
		while (!queue.isEmpty()) {
			ans++;
			int size = queue.size();
			while (size-- > 0) {
				final Integer poll = queue.poll();
				if (poll == targetNum) {
					return ans - 1;
				}
				int level = 1, tmp = poll;
				for (int i = 0; i < 4; i++) {
					// 每一位做上下拨动
					// 向上波动
					int up = poll + ((tmp % 10) == 9 ? -level * 9 : level);
					int down = poll - ((tmp % 10) == 0 ? -level * 9 : level);
					tmp /= 10;
					level *= 10;
					if (!exist.contains(up) && !hash.contains(up)) {
						queue.add(up);
						exist.add(up);
					}
					if (!exist.contains(down) && !hash.contains(down)) {
						queue.add(down);
						exist.add(down);
					}

				}
			}
		}
		return -1;
	}
}