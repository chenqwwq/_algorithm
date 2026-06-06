package top.chenqwwq.leetcode.daily._2021._20211210;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class Solution {
	public String shortestCompletingWord(String licensePlate, String[] words) {
		final int[] hash = getHash(licensePlate);
		String ans = null;
		outer:
		for (String word : words) {
			final int[] target = getHash(word);
			for (int i = 0; i < 26; i++) {
				if(target[i] < hash[i]){
					continue outer;
				}
			}
			if(ans == null || ans.length() > word.length()){
				ans = word;
			}
		}
		return ans;
	}

	public int[] getHash(String word) {
		final int[] hash = new int[26];
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) {
					c = Character.toLowerCase(c);
				}
				hash[c - 'a']++;
			}
		}
		return hash;
	}
}
