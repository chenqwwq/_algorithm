package top.chenqwwq.leetcode.archive.lcof2._18;

/**
 * @author chenbingxin
 * @date 2021/12/13
 **/
public class Solution {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		final int n = s.length();
		int left = 0, right = n - 1;

		while (left < right){
			if(!valid(s.charAt(left))){
				left++;
				continue;
			}
			if(!valid(s.charAt(right))){
				right--;
				continue;
			}
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;

	}

	private boolean valid(char c){
		return Character.isLetter(c) || Character.isDigit(c);
	}
}
