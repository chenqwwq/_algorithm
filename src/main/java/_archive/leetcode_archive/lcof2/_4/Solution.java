package top.chenqwwq.leetcode.archive.lcof2._4;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {
	public int singleNumber(int[] nums) {
		int ans = 0;
		for (int i = 0; i <= 31; i++) {
			int cnt = 0;
			for (int num : nums) {
				cnt += (num >> i & 1);
			}
			if (cnt % 3 == 1) {
				ans |= (1 << i);
			}
		}
		return ans;
	}
}