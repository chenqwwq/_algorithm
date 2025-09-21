package top.chenqwwq.leetcode.daily._2022._20221023;

/**
 * @author chenqwwq
 * @date 2022/10/23
 **/
public class Solution {
    public String mergeAlternately(String word1, String word2) {
        final int n = word1.length(),m = word2.length();
        int i = 0,j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n && j < m){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        while (i < n)sb.append(word1.charAt(i++));
        while (j < m) sb.append(word2.charAt(j++));
        return sb.toString();
    }
}