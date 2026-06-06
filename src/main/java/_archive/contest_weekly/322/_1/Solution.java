package top.chenqwwq.leetcode.contest.weekly._322._1;

/**
 * @author chenqwwq
 * @date 2022/12/8
 **/
public class Solution {
    public boolean isCircularSentence(String sentence) {
        final String[] words = sentence.split(" ");
        final int n = words.length;
        if (n == 1) return words[0].charAt(0) == words[0].charAt(words[0].length() - 1);
        if (words[0].charAt(0) != words[n - 1].charAt(words[n - 1].length() - 1)) return false;
        for (int i = 0; i < n - 1; i++) {
            if(words[i].charAt(words[i].length()-1) != words[i+1].charAt(0))return false;
        }
        return true;
    }
}