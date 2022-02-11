package top.chenqwwq.leetcode.biweek._52._2;

import java.util.Map;

/**
 * @author chen
 * @date 2021/5/15
 **/
public class Solution {
	public int[] memLeak(int memory1, int memory2) {
		int curr = 0;
		while (true) {
			curr++;
			if (memory1 >= memory2) {
				if (memory1 - curr < 0) {
					return new int[]{curr, memory1, memory2};
				}
				memory1 -= curr;
			} else {
				if (memory2 - curr < 0) {
					return new int[]{curr,memory1,memory2};
				}
				memory2 -= curr;
			}
		}
	}
}
