package top.chenqwwq.leetcode.contest.biweek._176._1;

/**
 * @author chenqwwq
 * @date 2026/2/14
 **/
public class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            int total = 0;
            for (char c : word.toCharArray()) {
                total += weights[c - 'a'];
            }
            ans.append((char) ('z' - (total % 26)));
        }
        return ans.toString();
    }
}