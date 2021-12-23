package top.chenqwwq.leetcode.weekly._272._1;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author chenbingxin
 * @date 2021/12/19
 **/
public class Solution {
	public String firstPalindrome(String[] words) {
		for (String word : words){
			if(check(word)){
				return word;
			}
		}
		return "";
	}

	private boolean check(String word) {
		int left = 0, right = word.length() - 1;
		while (left < right){
			if(word.charAt(left) != word.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}