package top.chenqwwq.leetcode.contest.weekly._294._1;

/**
 * @author chenqwwq
 * @date 2022/5/22
 **/
public class Solution {
    public int percentageLetter(String s, char letter) {
        int n = s.length();
        int m = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                m++;
            }
        }
        return (int)(1f * m / n * 100);
    }
}