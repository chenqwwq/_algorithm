package top.chenqwwq.leetcode.contest.weekly._491._1;

/**
 * @author chenqwwq
 * @date 2026/3/1
 **/
public class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 1; i >= 0; i--) {
            if ("aeiou".indexOf(sb.charAt(i)) != -1) {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}