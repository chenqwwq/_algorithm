package top.chenqwwq.leetcode.daily._20210528;

/**
 * @author chen
 * @date 2021/5/28
 **/
public class Solution {
	public int totalHammingDistance(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int cnt = 0;
			for (int num : nums) {
				cnt += (num >> i) & 1;
			}
			ans += (cnt * (nums.length - cnt));
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}