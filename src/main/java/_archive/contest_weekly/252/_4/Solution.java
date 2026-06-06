package top.chenqwwq.leetcode.contest.weekly._252._4;

/**
 * @author chen
 * @date 2021/8/1
 **/
public class Solution {
	public boolean isThree(int n) {
		int cnt = 1;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				cnt++;
			}
		}
		return cnt == 3;
	}
}