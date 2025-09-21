package top.chenqwwq.leetcode.daily._2025._20250203;

/**
 * @author chenqwwq
 * @date 2025/2/5
 **/
public class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s,0,s.length()-1,true);
    }

    public boolean validPalindrome(String s, int i, int j,boolean flag) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if(flag) return validPalindrome(s, i + 1, j,false) || validPalindrome(s, i, j - 1,false);
                return false;
            }
            i++;j--;
        }
        return true;
    }
}