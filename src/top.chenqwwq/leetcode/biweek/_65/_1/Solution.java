package top.chenqwwq.leetcode.biweek._65._1;

/**
 * @author chen
 * @date 2021-11-15
 **/
public class Solution {
	public boolean checkAlmostEquivalent(String word1, String word2) {
		int[] hash = new int[26];
		for (char c : word1.toCharArray()) {
			hash[c - 'a']++;
		}
		for (char c : word2.toCharArray()){
			hash[c - 'a']--;
		}
		for (int i : hash){
			if(Math.abs(i) > 3){
				return false;
			}
		}
		return true;
	}
}