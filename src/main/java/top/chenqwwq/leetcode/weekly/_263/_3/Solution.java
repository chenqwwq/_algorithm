package top.chenqwwq.leetcode.weekly._263._3;

/**
 * @author chen
 * @date 2021-10-18
 **/
public class Solution {
	int max = 0, cnt = 0;
	int[] nums;

	public int countMaxOrSubsets(int[] _nums) {
		nums = _nums;
		handle(0, 0);
		return cnt;
	}

	public void handle(int n, int curr) {
		if (n == nums.length) {
			if (curr == max) {
				cnt++;
			} else if (curr > max) {
				max = curr;
				cnt = 1;
			}
			return;
		}
		handle(n + 1, curr | nums[n]);
		handle(n + 1, curr);
	}

}