package top.chenqwwq.leetcode.lcof2._32;

/**
 * @author chenbingxin
 * @date 2021/12/28
 **/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) {
            return false;
        }
        int[] hash = new int[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (++hash[s.charAt(i) - 'a'] == 1) {
                cnt++;
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (--hash[t.charAt(i) - 'a'] == 0) {
                cnt--;
            }
        }
        return cnt == 0;
    }
}