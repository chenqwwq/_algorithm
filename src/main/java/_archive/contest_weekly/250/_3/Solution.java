package top.chenqwwq.leetcode.contest.weekly._250._3;

/**
 * @author chen
 * @date 2021/7/18
 **/
public class Solution {
	public int canBeTypedWords(String text, String brokenLetters) {
		boolean[] hash = new boolean[26];
		for (int i = 0; i < brokenLetters.length(); i++) {
			hash[brokenLetters.charAt(i) - 'a'] = true;
		}

		int ans = 0;
		outer:
		for (String word : text.split(" ")) {
			for (int i = 0; i < word.length(); i++) {
				if (hash[word.charAt(i) - 'a']) {
					continue outer;
				}
			}
			ans++;
		}
		return ans;
	}
}