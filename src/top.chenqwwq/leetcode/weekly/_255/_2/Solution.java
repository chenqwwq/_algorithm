package top.chenqwwq.leetcode.weekly._255._2;


import java.util.Collections;
import java.util.HashSet;

/**
 * @author chen
 * @date 2021/8/22
 **/
public class Solution {
	public static void main(String[] args) {
		new Solution().findDifferentBinaryString(new String[]{"01", "10"});
	}

	public String findDifferentBinaryString(String[] nums) {
		final int n = nums[0].length();
		HashSet<String> hash = new HashSet<>();
		Collections.addAll(hash, nums);

		for (int i = 0; i < 1 << n; i++) {
			final String ans = toString(i, n);
			if (!hash.contains(ans)) {
				return ans;
			}
		}
		return "";
	}

	public String toString(int num, int n) {
		StringBuilder ans = new StringBuilder();
		while (num > 0) {
			ans.insert(0, (num % 2));
			num /= 2;
		}
		while (ans.length() < n) {
			ans.insert(0, '0');
		}
		return ans.toString();
	}
}