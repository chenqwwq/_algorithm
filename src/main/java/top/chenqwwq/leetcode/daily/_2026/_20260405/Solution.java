package top.chenqwwq.leetcode.daily._2026._20260405;

/**
 * @author chenqwwq
 * @date 2026/4/6
 **/
public class Solution {
    public boolean judgeCircle(String moves) {
        int[] ms = new int[2];
        for (char c : moves.toCharArray()) {
            if (c == 'U') ms[0]++;
            else if (c == 'D') ms[0]--;
            else if (c == 'L') ms[1]++;
            else ms[1]--;
        }
        return ms[0] == ms[1] && ms[0] == 0;
    }
}