package top.chenqwwq.leetcode.week._252._2;

/**
 * @author chen
 * @date 2021/8/1
 **/
public class Solution {
	public long minimumPerimeter(long neededApples) {
		long total = 0, cur = 0;
		while (true) {
			if (neededApples <= total) {
				return 4 * cur;
			}
			cur += 2;
			final long max = cur - 1;
			final long min = (cur >> 1) + 1;
			final long sum = getSum(min, max);
			total += sum * 8 + 4 * (max + min);
		}
	}

	private long getSum(long min, long max) {
		if (min > max) {
			return 0;
		}
		return (max + min) * (max - min + 1) / 2;
	}
}