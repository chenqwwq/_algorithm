package top.chenqwwq.leetcode.biweek._63._2;

/**
 * @author chen
 * @date 2021-10-19
 **/
public class Solution {
	public boolean winnerOfGame(String colors) {
		int c1 = 0, c2 = 0, ac = 0, bc = 0;
		for (char c : colors.toCharArray()) {
			if (c == 'A') {
				if (++ac >= 3) {
					c1++;
				}
				bc = 0;
			} else {
				if (++bc >= 3) {
					c2++;
				}
				ac = 0;
			}
		}
		return c1 > c2;
	}
}