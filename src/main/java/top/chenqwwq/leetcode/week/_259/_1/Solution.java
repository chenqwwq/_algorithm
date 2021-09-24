package top.chenqwwq.leetcode.week._259._1;

/**
 * @author chen
 * @date 2021/9/19
 **/
public class Solution {
	public int finalValueAfterOperations(String[] operations) {
		int ans = 0;
		for (String opera : operations) {
			switch (opera) {
				case "++X":
					++ans;
					break;
				case "X++":
					ans++;
					break;
				case "--X":
					--ans;
					break;
				case "X--":
					ans--;
					break;
			}
		}
		return ans;

	}
}
