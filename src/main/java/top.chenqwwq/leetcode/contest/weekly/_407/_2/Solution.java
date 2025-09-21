package top.chenqwwq.leetcode.contest.weekly._407._2;

/**
 * @author chenqwwq
 * @date 2024/7/21
 **/
public class Solution {
    public boolean doesAliceWin(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
        }
        return cnt > 0;
    }
}