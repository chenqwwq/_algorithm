package top.chenqwwq.leetcode.contest.weekly._360._1;

import java.util.Map;

/**
 * @author chenqwwq
 * @date 2023/8/27
 **/
public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int c1 = 0, c2 = 0, c3 = 0;
        for (int i = 0; i < moves.length(); i++) {
            final char c = moves.charAt(i);
            if (c == 'L') c1++;
            else if (c == 'R') c2++;
            else c3++;
        }
        return Math.max(c1 + c3 - c2, c2 + c3 - c1);
    }
}