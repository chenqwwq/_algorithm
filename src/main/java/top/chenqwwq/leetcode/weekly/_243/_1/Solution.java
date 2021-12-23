package top.chenqwwq.leetcode.weekly._243._1;

/**
 * @author chen
 * @date 2021/5/30
 **/
public class Solution {
	public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
		return (getNum(firstWord) + getNum(secondWord)) == getNum(targetWord);
	}

	public Long getNum(String word) {
		long ans = 0;
		for (int i = 0; i < word.length(); i++) {
			ans = ans * 10 + (word.charAt(i) - 'a');
		}
		return ans;
	}
}