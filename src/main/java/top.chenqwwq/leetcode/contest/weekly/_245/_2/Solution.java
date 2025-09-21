package top.chenqwwq.leetcode.contest.weekly._245._2;

/**
 * @author chen
 * @date 2021/6/13
 **/
public class Solution {

	public static void main(String[] args) {
		new Solution().maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4});
	}

	public int maximumRemovals(String s, String p, int[] removable) {
		int left = 0, right = removable.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			final StringBuilder string = new StringBuilder(s);
			for (int i = 0; i <= mid; i++) {
				string.setCharAt(removable[i], '#');
			}
			if (isSubsequence(p, string.toString())) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	public boolean isSubsequence(String s, String t) {
		int n = s.length(), m = t.length();
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == n;
	}
}