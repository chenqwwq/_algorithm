package top.chenqwwq.leetcode.week._254._1;

/**
 * @author chen
 * @date 2021/8/15
 **/
public class Solution {
	public int numOfStrings(String[] patterns, String word) {
		int ans = 0;
		for (int i = 0; i < patterns.length; i++) {
			if (word.contains(patterns[i])) {
				ans++;
			}
		}
		return ans;
	}
}